import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class COD01 {

    static String[] fileList = {"music", "images", "movies", "other"};

    public String solution(String S) {

        StringBuilder answer = new StringBuilder();

        HashMap<String, Integer> fileHashmap = new HashMap<>();
        fileHashmap.put(fileList[0], 0);
        fileHashmap.put(fileList[1], 0);
        fileHashmap.put(fileList[2], 0);
        fileHashmap.put(fileList[3], 0);

        String[] splitS = S.split("\\n");

        for (int i = 0; i < splitS.length; i++) {
            String[] indexS = splitS[i].split(" ");
            String fileName = checkExtension(indexS[0].substring(indexS[0].lastIndexOf(".")));
            int volume = Integer.parseInt(indexS[1].replaceAll("b", ""));
            fileHashmap.put(fileName, fileHashmap.getOrDefault(fileName, 0) + volume);
        }

        for (int i = 0; i < 4; i++) {
            answer.append(fileList[i]);
            answer.append(" ");
            answer.append(fileHashmap.get(fileList[i]));
            answer.append("b\n");
        }

        return answer.toString();
    }

    public String checkExtension(String ext) {
        String[] music = {"mp3", "aac", "flac"};
        String[] images = {"jpg", "bmp", "gif"};
        String[] movies = {"mp4", "avi", "mkv"};

        String removeDot = ext.replaceAll("\\.", "");
        if (Arrays.asList(music).contains(removeDot)) {
            return fileList[0];
        } else if (Arrays.asList(images).contains(removeDot)) {
            return fileList[1];
        } else if (Arrays.asList(movies).contains(removeDot)) {
            return fileList[2];
        } else {
            return fileList[3];
        }
    }

    public static void main(String[] args) throws IOException {

        COD01 solution = new COD01();
        String s = "my.song.mp3 11b\n" +
                "greatSong.flac 1000b\n" +
                "not3.txt 5b\n" +
                "video.7z 200b\n" +
                "game.exe 100b\n" +
                "mov!e.mkv 10000b";
        System.out.println(solution.solution(s));
    }
}
