package com.kydw.criminalintent.database;

/**
 * @author liuqian
 * @date 2018/7/26 20:16
 */
public class CrimeDbSchema {
    public static final class CrimeTable {
        public static final String NAME = "crimes";
        public static final class Cols {
            public static final String UUID = "uuid";
            public static final String TITLE = "title";
            public static final String DATE = "date";
            public static final String SOLVED = "solved";
        }
    }
}
