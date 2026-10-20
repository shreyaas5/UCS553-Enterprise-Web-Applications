package q2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Objects;

class Song {
    private String title;
    private String artist;
    private String duration;

    public Song(String title, String artist, String duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getDuration() {
        return duration;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Song song = (Song) obj;
        return title.equalsIgnoreCase(song.title) && artist.equalsIgnoreCase(song.artist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title.toLowerCase(), artist.toLowerCase());
    }

    @Override
    public String toString() {
        return title + " - " + artist + " (" + duration + ")";
    }
}

class MediaPlayerQueue {
    private LinkedList<Song> queue;
    private LinkedList<Song> history;

    public MediaPlayerQueue() {
        queue = new LinkedList<>();
        history = new LinkedList<>();
    }

    public void addSong(Song song) {
        queue.add(song);
        System.out.println("Added to queue: " + song);
    }

    public void addSongToFront(Song song) {
        queue.addFirst(song);
        System.out.println("Priority added to front: " + song);
    }

    public void insertSong(int index, Song song) {
        if (index >= 0 && index <= queue.size()) {
            queue.add(index, song);
            System.out.println("Inserted at position " + index + ": " + song);
        } else {
            System.out.println("Invalid position for insertion: " + index);
        }
    }

    public void removeDuplicates() {
        HashSet<Song> seen = new HashSet<>();
        Iterator<Song> it = queue.iterator();
        int count = 0;
        while (it.hasNext()) {
            Song s = it.next();
            if (seen.contains(s)) {
                it.remove();
                count++;
            } else {
                seen.add(s);
            }
        }
        System.out.println("Removed " + count + " duplicate song(s) from queue.");
    }

    public void playNext() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty. No song to play.");
            return;
        }
        Song current = queue.removeFirst();
        history.add(current);
        System.out.println("Now Playing: " + current);
    }

    public void displayQueue() {
        System.out.println("\nCurrent Playback Queue (" + queue.size() + " songs):");
        if (queue.isEmpty()) {
            System.out.println("  (Empty)");
            return;
        }
        int idx = 1;
        for (Song s : queue) {
            System.out.println("  " + idx + ". " + s);
            idx++;
        }
    }

    public void displayHistory() {
        System.out.println("\nRecently Played History (" + history.size() + " songs):");
        if (history.isEmpty()) {
            System.out.println("  (Empty)");
            return;
        }
        int idx = 1;
        for (Song s : history) {
            System.out.println("  " + idx + ". " + s);
            idx++;
        }
    }

    public void traverseBidirectional() {
        System.out.println("\nBidirectional Traversal using ListIterator:");
        ListIterator<Song> it = queue.listIterator();

        System.out.println("Forward traversal:");
        while (it.hasNext()) {
            int nextIndex = it.nextIndex();
            Song s = it.next();
            System.out.println("  [" + nextIndex + "] Forward -> " + s);
        }

        System.out.println("\nBackward traversal:");
        while (it.hasPrevious()) {
            int prevIndex = it.previousIndex();
            Song s = it.previous();
            System.out.println("  [" + prevIndex + "] Backward <- " + s);
        }
    }
}

public class Question2 {
    public static void main(String[] args) {
        System.out.println("=== Media Player Queue Engine ===");

        MediaPlayerQueue player = new MediaPlayerQueue();

        Song s1 = new Song("Starboy", "The Weeknd", "3:50");
        Song s2 = new Song("Shape of You", "Ed Sheeran", "3:53");
        Song s3 = new Song("Blinding Lights", "The Weeknd", "3:20");
        Song s4 = new Song("Believer", "Imagine Dragons", "3:24");
        Song s5 = new Song("Shape of You", "Ed Sheeran", "3:53"); // duplicate
        Song s6 = new Song("Starboy", "The Weeknd", "3:50");     // duplicate
        Song prioritySong = new Song("Bohemian Rhapsody", "Queen", "5:55");

        System.out.println("\n1. Adding songs to queue:");
        player.addSong(s1);
        player.addSong(s2);
        player.addSong(s3);

        System.out.println("\n2. Priority queueing (Adding to front):");
        player.addSongToFront(prioritySong);

        System.out.println("\n3. Inserting song at arbitrary position (index 2):");
        player.insertSong(2, s4);

        System.out.println("\n4. Adding duplicates to queue:");
        player.addSong(s5);
        player.addSong(s6);

        player.displayQueue();

        System.out.println("\n5. Removing duplicate songs using HashSet:");
        player.removeDuplicates();

        player.displayQueue();

        System.out.println("\n6. Playing songs and tracking history:");
        player.playNext();
        player.playNext();

        player.displayHistory();
        player.displayQueue();

        System.out.println("\n7. Bidirectional navigation over remaining queue:");
        player.traverseBidirectional();
    }
}
