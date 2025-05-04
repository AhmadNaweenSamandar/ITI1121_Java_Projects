import java.util.Arrays;
import java.io.*;
import java.util.Comparator;

public class PlayList {

    private Song[] songs;
    private int count;
    private int capacityIncrement;

    public PlayList(int initialCapacity, int capacityIncrement) {
        if (initialCapacity < 1)
            throw new IllegalArgumentException("Illegal capacity: " + initialCapacity);
        if (capacityIncrement < 1)
            throw new IllegalArgumentException("Illegal increment: " + capacityIncrement);

        songs = new Song[initialCapacity];
        this.capacityIncrement = capacityIncrement;
    }

    public PlayList(int initialCapacity) {
        this(initialCapacity, 10);
    }

    public PlayList() {
        this(10, 10);
    }

    public int getSize() {
        return count;
    }

    public boolean addSong(Song song) {
        if (song == null)
            throw new IllegalArgumentException("null is not a valid argument");

        for (int i = 0; i < count; i++)
            if (songs[i].equals(song))
                return false;

        if (count == songs.length) {
            Song[] tmp = songs;
            songs = new Song[tmp.length + capacityIncrement];
            System.arraycopy(tmp, 0, songs, 0, tmp.length);
        }

        songs[count++] = song;
        return true;
    }

    public Song getSongAt(int index) {
        if (index < 0 || index >= count)
            throw new IndexOutOfBoundsException("" + index);
        return songs[index];
    }

    public void sort(Comparator<Song> c) {
        Arrays.sort(songs, 0, count, c);
    }

    public void sort2(Comparator<Song> c) {
        for (int i = 0; i < count; i++) {
            int min = i;
            for (int j = i + 1; j < count; j++)
                if (c.compare(songs[j], songs[min]) < 0)
                    min = j;
            Song tmp = songs[min];
            songs[min] = songs[i];
            songs[i] = tmp;
        }
    }

    public static PlayList getSongsFromFile(String fileName) throws IOException {
        PlayList playlist = new PlayList();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    try {
                        Song song = Song.parseSong(line);
                        playlist.addSong(song);
                    } catch (Exception e) {
                        System.err.println("Skipping invalid line: " + line);
                    }
                }
            }
        }
        return playlist;
    }

    public void writeSongsToFile(String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = 0; i < count; i++) {
                writer.write(songs[i].toString());
                writer.newLine();
            }
        }
    }

    public boolean equals(PlayList other) {
        if (other == null) return false;
        if (count != other.count || capacityIncrement != other.capacityIncrement)
            return false;
        for (int i = 0; i < count; i++)
            if (!songs[i].equals(other.songs[i]))
                return false;
        return true;
    }

    public String toString() {
        StringBuilder result = new StringBuilder("PlayList:\n");
        for (int i = 0; i < count; i++)
            result.append("\t").append(songs[i].toString()).append("\n");
        result.append("Count: ").append(count).append("\nCapacityIncrement: ").append(capacityIncrement);
        return result.toString();
    }

    // Example usage
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java PlayList <inputFile> [outputFile]");
            return;
        }

        try {
            PlayList playlist = PlayList.getSongsFromFile(args[0]);
            
            // Sort by name
            playlist.sort(new SortByName());
            System.out.println("Sorted by name:");
            System.out.println(playlist);
            
            // Sort by artist
            playlist.sort(new SortByArtist());
            System.out.println("\nSorted by artist:");
            System.out.println(playlist);
            
            // Sort by album
            playlist.sort(new SortByAlbum());
            System.out.println("\nSorted by album:");
            System.out.println(playlist);

            if (args.length > 1) {
                playlist.writeSongsToFile(args[1]);
                System.out.println("\nPlaylist written to: " + args[1]);
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}