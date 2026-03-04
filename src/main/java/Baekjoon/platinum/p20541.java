package Baekjoon.platinum;

import java.io.*;
import java.util.*;

public class p20541 {

    private static final String ROOT = "album";
    private static StringBuilder sb = new StringBuilder();
    private static final Album rootAlbum = new Album(null, ROOT);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Album currentAlbum = rootAlbum;
        for(int i = 0; i < n; i++){
            String command = br.readLine();
            StringTokenizer st = new StringTokenizer(command);
            String commandType = st.nextToken();
            String arg = st.nextToken();

            switch (commandType){
                case "mkalb":
                    currentAlbum.mkalb(arg, currentAlbum);
                    break;
                case "rmalb":
                    currentAlbum.rmalb(arg, currentAlbum);
                    break;
                case "insert":
                    currentAlbum.insert(arg);
                    break;
                case "delete":
                    currentAlbum.delete(arg);
                    break;
                case "ca":
                    switch(arg){
                        case "..":
                            if(!currentAlbum.isRoot()){
                                currentAlbum = currentAlbum.parent;
                            }
                            break;
                        case "/":
                            currentAlbum = rootAlbum;
                            break;
                        default:
                            if(currentAlbum.albumsHash.contains(arg)){
                                currentAlbum = currentAlbum.albums.get(arg);
                            }
                            break;
                    }
                    sb.append(currentAlbum.name).append(System.lineSeparator());
                    break;
            }

        }

        System.out.println(sb);

    }

    private static class Album{
        Album parent;
        String name;
        NavigableMap<String, Album> albums = new TreeMap<>(String::compareTo);
        NavigableMap<String, Photo> photos = new TreeMap<>(String::compareTo);
        Set<String> albumsHash = new HashSet<>();
        Set<String> photosHash = new HashSet<>();

        Album(Album parent, String name){
            this.parent = parent;
            this.name = name;
        }

        public boolean isRoot(){
            return this.parent == null;
        }

        public void mkalb(String s, Album album){
            if(!albumsHash.add(s)){
                //false면 이미 set에 존재 => 중복
                sb.append("duplicated album name").append(System.lineSeparator());
            } else {
                this.albums.put(s, new Album(album, s));
            }
        }

        public void rmalb(String arg, Album currentAlbum) {
            int albumRemoveCount = 0;
            int photoRemoveCount = 0;
            switch (arg){
                case "-1":
                    if (albums.isEmpty()) {
                        sb.append("0 0").append('\n');
                        return;
                    }
                    //사전순 가장 늦은 앨범 삭제
                    Map.Entry<String, Album> firstEntry = albums.pollFirstEntry();
                    photoRemoveCount += firstEntry.getValue().photos.size();
                    albumRemoveCount += deepAlbumsCount(firstEntry.getValue());
                    photoRemoveCount += deepPhotosCount(firstEntry.getValue());
                    albumRemoveCount++;
                    albumsHash.remove(firstEntry.getKey());
                    break;
                case "0":
                    //현재 앨범에 속해있는 모든 앨범 모두 삭제
                    for(Map.Entry<String, Album> entry: albums.entrySet()){
                        albumRemoveCount++;
                        Album nowAlbum = entry.getValue();
                        albumRemoveCount += deepAlbumsCount(nowAlbum);
                        photoRemoveCount += deepPhotosCount(nowAlbum);
                        photoRemoveCount += entry.getValue().photos.size();
                        albumsHash.remove(entry.getKey());
                    }
                    albums.clear();
                    albumsHash.clear();
                    break;
                case "1":
                    if (albums.isEmpty()) {
                        sb.append("0 0").append('\n');
                        return;
                    }
                    //사전순으로 가장 빠른 앨범 삭제
                    Map.Entry<String, Album> lastEntry = albums.pollLastEntry();
                    photoRemoveCount += lastEntry.getValue().photos.size();
                    albumRemoveCount += deepAlbumsCount(lastEntry.getValue());
                    photoRemoveCount += deepPhotosCount(lastEntry.getValue());
                    albumRemoveCount++;
                    albumsHash.remove(lastEntry.getKey());
                    break;
                default:
                    //삭제될 앨범에 속한 모든 앨범과 사진 모두 삭제
                    if(albumsHash.contains(arg)){
                        Album removeAlbum = albums.get(arg);
                        photoRemoveCount += removeAlbum.photos.size();
                        albumRemoveCount += deepAlbumsCount(removeAlbum);
                        photoRemoveCount += deepPhotosCount(removeAlbum);
                        albums.remove(arg);
                        albumsHash.remove(arg);
                        currentAlbum.albums.remove(arg);
                        albumRemoveCount++;
                    }
                    break;
            }

            sb.append(albumRemoveCount).append(" ").append(photoRemoveCount).append(System.lineSeparator());
        }

        private int deepAlbumsCount(Album nowAlbum){
            int number = 0;
            for (Album child : nowAlbum.albums.values()){
                number += 1;
                number += deepAlbumsCount(child);
            }
            return number;
        }

        private int deepPhotosCount(Album nowAlbum){
            int number = 0;
            for (Album child : nowAlbum.albums.values()){
                number += child.photos.size();
                number += deepPhotosCount(child);
            }
            return number;
        }

        public void insert(String arg) {
            if(!photosHash.add(arg)){
                sb.append("duplicated photo name").append(System.lineSeparator());
            } else {
                this.photos.put(arg, new Photo(arg));
            }
        }

        public void delete(String arg) {
            int photoRemoveCount = 0;
            switch (arg){
                case "-1":
                    if (photos.isEmpty()) {
                        sb.append("0").append('\n');
                        return;
                    }
                    photosHash.remove(photos.pollFirstEntry().getKey());
                    photoRemoveCount++;
                    break;
                case "0":
                    photoRemoveCount += photos.size();
                    photosHash.clear();
                    photos.clear();
                    break;
                case "1":
                    if (photos.isEmpty()) {
                        sb.append("0").append('\n');
                        return;
                    }
                    photosHash.remove(photos.pollLastEntry().getKey());
                    photoRemoveCount++;
                    break;
                default:
                    if(photosHash.contains(arg)){
                        photos.remove(arg);
                        photosHash.remove(arg);
                        photoRemoveCount++;
                    }
                    break;
            }
            sb.append(photoRemoveCount).append(System.lineSeparator());
        }
    }

    private static class Photo{
        String name;

        Photo(String name){
            this.name = name;
        }
    }
}
