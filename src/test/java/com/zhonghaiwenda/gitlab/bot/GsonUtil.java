package com.zhonghaiwenda.gitlab.bot;


import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author gxz
 * @date 2021/2/8 14:42
 */
public class GsonUtil {

    @Test
    public void reset() throws IOException {
      /*  File file = new File("C:\\workSpace\\java\\gitlab-bot\\src\\main\\java\\com\\zhonghaiwenda\\gitlab\\bot\\model\\webhook\\event\\MergeRequest.java");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        int index = 0;
        while ((line = bufferedReader.readLine()) != null) {
            if (index != 0) {
                index = (index + 1) % 3;
                continue;
            }
            if (line.contains("(")) {
                index = 1;
                continue;
            }
            if (line.contains("private ")) {
                line = _replace(line);
            }
            stringBuilder.append(line+"\r\n");

        }
       FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(stringBuilder.toString());
        fileWriter.flush();*/

    }




    private String _replace(String line) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = line.toCharArray();
        boolean nextToUp = false;
        for (char aChar : chars) {
            if (nextToUp) {
                nextToUp = false;
                String up = (aChar + "").toUpperCase();
                stringBuilder.append(up);
                continue;
            }
            if (aChar == '_') {
                nextToUp = true;
                continue;
            }
            stringBuilder.append(aChar);
        }
        return stringBuilder.toString();
    }
}
