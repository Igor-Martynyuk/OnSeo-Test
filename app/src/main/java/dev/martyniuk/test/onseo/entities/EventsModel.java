package dev.martyniuk.test.onseo.entities;

import java.util.Calendar;
import java.util.List;

public class EventsModel {

    public static class Sport {
        private String id;
        private List<Event> events;
    }

    public static class Event {
        private String id;
        private String name;
        private Calendar startTime;
        private Type type;
        private boolean isInPlay;
        private List<Boolean> participants;

        enum Type {
            HEAD_TO_HEAD
        }

        public static class Participant {
            private String id;
            private String name;

            public String getId() {
                return id;
            }

            public String getName() {
                return name;
            }
        }

        public static class Scoreboard {
            public static class Period {
                private String id;
                private String nameFull;
                private String nameShort;
            }
        }
    }

}
