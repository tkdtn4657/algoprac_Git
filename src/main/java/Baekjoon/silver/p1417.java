package Baekjoon.silver;

import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;

public class p1417 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = 0;
        int n = Integer.parseInt(br.readLine());
        Queue<Candidate> candiQ = new PriorityQueue<>(n+8);

        Candidate dasom = new Candidate(1, Integer.parseInt(br.readLine()));

        for(int i = 2; i < n+1;i++){
            int receveVote = Integer.parseInt(br.readLine());
            candiQ.offer(new Candidate(i, receveVote));
        }

        if(candiQ.isEmpty()){
            System.out.println(0);
            return;
        }

        //기호1번을 1등으로
        while (dasom.getReceveVote() <= candiQ.peek().getReceveVote()){
            candiQ.peek().voteControl(0);
            Candidate temp = candiQ.poll();
            candiQ.offer(temp);
            dasom.voteControl(1);
            count++;
        }

        System.out.println(count);
    }
}


/**
 * 후보자번호, 받은 득표수가 들어있는 후보객체
 * 우선순위큐를 위해 Comparable을 상속받음
 */
class Candidate implements Comparable<Candidate>{
    private final int number;

    private int receveVote = 0;

    Candidate(int number) {
        this.number = number;
    }

    Candidate(int number, int receveVote) {
        this.number = number;
        this.receveVote = receveVote;
    }

    @Override
    public int compareTo(Candidate o) {
        //receveVote 내림차순정렬
        return o.receveVote - receveVote;
    }

    public int getReceveVote() {
        return receveVote;
    }

    public int getNumber() {
        return number;
    }

    public void voteControl(int mode){
        if(mode == 0){
            receveVote--;
            return;
        }
        receveVote++;

    }
}
