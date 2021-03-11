import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.nio.file.Files;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Pathtest {

    public class PathsTest {

        public void path_exists() throws Exception {

        }
    }

    public static void main(String[] args) throws IOException {

        // http://tutorials.jenkov.com/java-nio/path.html

        /*
        Creating an absolute Path
         */

//        Path path = Paths.get("C:\\Users\\Daniel\\Desktop\\Revature\\3-11-21\\Time\\windows\\license.txt");
//
//        System.out.println(path.normalize());
//
//
//        // This just points to the windows Folder/Directory
//        Path projects = Paths.get("C:\\Users", "\\Daniel", "\\Desktop", "\\Revature", "\\3-11-21", "\\Time", "\\Windows");
//

          //Creating Relative Paths
//        //Get the current Folder/Directory
//        Path currentDir = Paths.get(".");
//        System.out.println(currentDir);
//        //System.out.println(currentDir.toAbsolutePath());
//
//        Path parentDir = Paths.get("..");
//        System.out.println(parentDir);
//        //System.out.println(parentDir.toAbsolutePath());



        //reativize() - Can create a new path which represents the second Path relative to the first path


        Path basePath = Paths.get("\\Users");

        Path paths = Paths.get("\\Users\\Daniel\\Desktop\\Revature\\3-11-21\\Time\\windows\\license.txt");
       // Path paths = Paths.get("C:\\Users\\Daniel\\Desktop\\Revature\\Revature_WorkSpace\\forTesting.txt");


        Path basePathToPath = basePath.relativize(paths);
        Path pathToBasePath = paths.relativize(basePath);

        System.out.println(basePathToPath);
        System.out.println(pathToBasePath);


//        Path basePath2 = Paths.get("\\Users\\Daniel\\Desktop\\Revature\\3-11-21\\Time\\windows\\");
//        Path path2     = Paths.get("license.txt");
//        System.out.println(basePath2);
//
//        Path basePathToPath3 = basePath.relativize(path2);
//        System.out.println(basePathToPath3);



        

        BufferedReader in = null;
        try {
             in = new BufferedReader(new FileReader(pathToBasePath.toString()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String strCurrentLine;
        while ((strCurrentLine = in.readLine()) != null) {
            System.out.println("--");
            System.out.println(strCurrentLine);
        }


//        FileWriter fw = new FileWriter( path.toString(), true);
//        BufferedWriter bw = new BufferedWriter(fw);
//        try (BufferedWriter bufferedWriter = new BufferedWriter(bw)) {
//                bufferedWriter.newLine();
//                bufferedWriter.append("Does this overwrite Testing");
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//
//
//        while ((strCurrentLine = in.readLine()) != null) {
//            System.out.println(strCurrentLine);
//        }


//        System.out.println(path);
//
//        System.out.println(Files.exists(path));
//
//        path = Paths.get("C:/Users/Daniel/Desktop/Revature/EnterpiseTestingFrameWork/Enterprise-Testing-Framework/Time/windows/license.txt");
//
//        System.out.println(Files.exists(path));
//
//        path = Paths.get("C:","Users", "Daniel", "Desktop","Revature","EnterpiseTestingFrameWork","Enterprise-Testing-Framework","Time","windows","license.txt");
//        System.out.println(Files.exists(path));
//
//        path = Paths.get("C:","Users", "Daniel", "Desktop","Revature","EnterpiseTestingFrameWork","Enterprise-Testing-Framework","Time","windows").resolve("license.txt");
//        System.out.println(Files.exists(path));

    }

    public void whenWriteStringUsingBufferedWritter_thenCorrect(Path path)
            throws IOException {
        String str = "Hello";
        BufferedWriter writer = new BufferedWriter(new FileWriter(path.toString()));
        writer.write(str);

        writer.close();
    }

    public void givenWritingStringToFile_whenUsingPrintWriter_thenCorrect(Path path)
            throws IOException {
        FileWriter fileWriter = new FileWriter(path.toString());
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print("Some String");
        printWriter.printf("Product name is %s and its price is %d $", "iPhone", 1000);
        printWriter.close();
    }

    public void givenWritingStringToFile_whenUsingFileOutputStream_thenCorrect(Path path)
            throws IOException {
        String str = "Hello";
        FileOutputStream outputStream = new FileOutputStream(path.toString());
        byte[] strToBytes = str.getBytes();
        outputStream.write(strToBytes);

        outputStream.close();
    }

    public void givenWritingToFile_whenUsingDataOutputStream_thenCorrect(Path path)
            throws IOException {
        String value = "Hello";
        FileOutputStream fos = new FileOutputStream(path.toString());
        DataOutputStream outStream = new DataOutputStream(new BufferedOutputStream(fos));
        outStream.writeUTF(value);
        outStream.close();

        // verify the results
        String result;
        FileInputStream fis = new FileInputStream(path.toString());
        DataInputStream reader = new DataInputStream(fis);
        result = reader.readUTF();
        reader.close();

//        assertEquals(value, result);
    }

    private void writeToPosition(String filename, int data, long position)
            throws IOException {
        RandomAccessFile writer = new RandomAccessFile(filename, "rw");
        writer.seek(position);
        writer.writeInt(data);
        writer.close();
    }

    private int readFromPosition(String filename, long position)
            throws IOException {
        int result = 0;
        RandomAccessFile reader = new RandomAccessFile(filename, "r");
        reader.seek(position);
        result = reader.readInt();
        reader.close();
        return result;
    }

    public void whenWritingToSpecificPositionInFile_thenCorrect(Path path)
            throws IOException {
        int data1 = 2014;
        int data2 = 1500;

        writeToPosition(path.toString(), data1, 4);
//        assertEquals(data1, readFromPosition(fileName, 4));

        writeToPosition(path.toString(), data2, 4);
//        assertEquals(data2, readFromPosition(fileName, 4));
    }

    public void givenWritingToFile_whenUsingFileChannel_thenCorrect(Path path)
            throws IOException {
        RandomAccessFile stream = new RandomAccessFile(path.toString(), "rw");
        FileChannel channel = stream.getChannel();
        String value = "Hello";
        byte[] strBytes = value.getBytes();
        ByteBuffer buffer = ByteBuffer.allocate(strBytes.length);
        buffer.put(strBytes);
        buffer.flip();
        channel.write(buffer);
        stream.close();
        channel.close();

        // verify
        RandomAccessFile reader = new RandomAccessFile(path.toString(), "r");
        reader.close();
    }

    public void givenUsingJava7_whenWritingToFile_thenCorrect(Path path)
            throws IOException {
        String str = "Hello";


        byte[] strToBytes = str.getBytes();

        Files.write(path, strToBytes);

        String read = Files.readAllLines(path).get(0);
    }

    public void whenWriteToTmpFile_thenCorrect() throws IOException {
        String toWrite = "Hello";
        File tmpFile = File.createTempFile("test", ".tmp");
        FileWriter writer = new FileWriter(tmpFile);
        writer.write(toWrite);
        writer.close();

        BufferedReader reader = new BufferedReader(new FileReader(tmpFile));
//        assertEquals(toWrite, reader.readLine());
        reader.close();
    }

    public void whenTryToLockFile_thenItShouldBeLocked(Path path)
            throws IOException {
        RandomAccessFile stream = new RandomAccessFile(path.toString(), "rw");
        FileChannel channel = stream.getChannel();

        FileLock lock = null;
        try {
            lock = channel.tryLock();
        } catch (final OverlappingFileLockException e) {
            stream.close();
            channel.close();
        }
        stream.writeChars("test lock");
        lock.release();

        stream.close();
        channel.close();
    }

}




