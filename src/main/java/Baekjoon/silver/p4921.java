package Baekjoon.silver;

import java.io.*;
import java.util.*;


/**
 * 오른쪽만 체크하기
 *
 */
public class p4921 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int testCaseNumber = 1;

        String command = br.readLine();
        while(!command.equals("0")){
            if(command.length() <= 2) {
                sb.append(testCaseNumber++).append(". NOT").append("\n");
                command = br.readLine();
                continue;
            }
                caseEnd:
                for (int i = 0; i < command.length(); i++) {
                    char nowChar = command.charAt(i);
                    switch (nowChar) {
                        case '1':
                            if (i != 0) {
                                sb.append(testCaseNumber++).append(". NOT").append("\n");
                                break caseEnd;
                            }
                            if (i == 0 && command.length() - 1 != i) {
                                if (command.charAt(i + 1) - '0' == 4) {
                                    break;
                                }
                                if (command.charAt(i + 1) - '0' == 5) {
                                    break;
                                }
                                sb.append(testCaseNumber++).append(". NOT").append("\n");
                                break caseEnd;
                            }
                            break caseEnd;
                        case '2':
                            if (command.length() - 1 == i) {
                                sb.append(testCaseNumber++).append(". VALID").append("\n");
                                break caseEnd;
                            }
                            sb.append(testCaseNumber++).append(". NOT").append("\n");
                            break caseEnd;
                        case '3':
                            if (command.length() - 1 == i) {
                                sb.append(testCaseNumber++).append(". NOT").append("\n");
                                break caseEnd;
                            }
                            if (i != 0 && command.length() - 1 != i) {
                                if (command.charAt(i + 1) - '0' == 4) {
                                    break;
                                }
                                if (command.charAt(i + 1) - '0' == 5) {
                                    break;
                                }
                                sb.append(testCaseNumber++).append(". NOT").append("\n");
                                break caseEnd;
                            }
                            break;
                        case '4', '6':
                            if (command.length() - 1 == i) {
                                sb.append(testCaseNumber++).append(". NOT").append("\n");
                                break caseEnd;
                            }
                            if (i != 0 && command.length() - 1 != i) {
                                if (command.charAt(i + 1) - '0' == 2) {
                                    break;
                                }
                                if (command.charAt(i + 1) - '0' == 3) {
                                    break;
                                }
                                sb.append(testCaseNumber++).append(". NOT").append("\n");
                                break caseEnd;
                            }
                            break;
                        case '5', '7':
                            if (command.length() - 1 == i) {
                                sb.append(testCaseNumber++).append(". NOT").append("\n");
                                break caseEnd;
                            }
                            if (i != 0 && command.length() - 1 != i) {
                                if (command.charAt(i + 1) - '0' == 8) {
                                    break;
                                }
                                sb.append(testCaseNumber++).append(". NOT").append("\n");
                                break caseEnd;
                            }
                            break;
                        case '8':
                            if (command.length() - 1 == i) {
                                sb.append(testCaseNumber++).append(". NOT").append("\n");
                                break caseEnd;
                            }
                            if (i != 0 && command.length() - 1 != i) {
                                if (command.charAt(i + 1) - '0' == 7) {
                                    break;
                                }
                                if (command.charAt(i + 1) - '0' == 6) {
                                    break;
                                }
                                sb.append(testCaseNumber++).append(". NOT").append("\n");
                                break caseEnd;
                            }

                            break;
                    }
                }

            command = br.readLine();
        }

        System.out.println(sb);

    }

}
