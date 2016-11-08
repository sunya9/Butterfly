package net.unsweets.butterfly.appnet.models;

import java.util.List;

public class Token {
    public Data data;
    public Meta meta;

    public static class Data {
        public App app;
        public Limits limits;
        public List<String> lscopes;
        public Storage storage;
        public User user;
        public String invite_link;
    }

    public static class App {
        public String client_id;
        public String link;
        public String name;
    }

    public static class Limits {
        public int following;
        public int max_file_size;
    }

    public static class Storage {
        public int available;
        public int used;
    }
}

