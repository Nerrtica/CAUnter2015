package kr.ac.cau.cse.caunter2015.eventsetupactivity.model;

import java.util.Comparator;

/**
 * Created by Julian on 2015-08-13.
 */
public enum EventComparator implements java.util.Comparator<EventData> {
    ByNameAsc {
        @Override
        public int compare(EventData o1, EventData o2) {
            return o1.getName().compareTo(o2.getName());
        }
    },
    ByStartAsc {
        @Override
        public int compare(EventData o1, EventData o2) {
            return o1.getStart().compareTo(o2.getStart());
        }
    },
    ByEndAsc {
        @Override
        public int compare(EventData o1, EventData o2) {
            return o1.getEnds().compareTo(o2.getEnds());
        }
    };

    public static Comparator<EventData> descendingComparator(final Comparator<EventData> original) {
        return new Comparator<EventData>() {
            public int compare(EventData o1, EventData o2) {
                return -1 * original.compare(o1, o2);
            }
        };
    }
}
