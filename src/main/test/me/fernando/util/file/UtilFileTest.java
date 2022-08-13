package me.fernando.util.file;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilFileTest {

    @Test
    void countLines() {
        int lines = UtilFile.countLines("/Users/fernando/IdeaProjects/Classroom/src/main/resources/TestFile.txt");
        assertEquals(17, lines);
    }

    @Test
    void countCharacters() {
        int characters = UtilFile.countCharacters("/Users/fernando/IdeaProjects/Classroom/src/main/resources/TestFile.txt");
        assertEquals(1212, characters);
    }
}
