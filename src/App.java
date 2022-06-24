import models.Footer;
import models.Header;
import models.IDModel;
import utils.AppConstant;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static final String FILE_PATH_INPUT = "C:\\Users\\qdang7\\OneDrive - DXC Production\\Documents\\ID116651.C2N";
    public static final String FILE_PATH_OUTPUT = "C:\\Users\\qdang7\\OneDrive - DXC Production\\Documents\\DXC_ZurichSteel\\Files Container\\idunproc.C2N";
    private static boolean breakLoop = false;
    private static int byteBuffCursor = 0;

    private static String gVarBuffer1;
    private String gVarBuffer2;
    private String gVarBuffer3;
    private String gVarBuffer4;


    public static Header readHeader(String data) throws IOException {
        Header header = new Header();
        header.setHeaderIdent(data.substring(byteBuffCursor, byteBuffCursor += AppConstant.LEN_HeaderIdent));
        header.setTransCode(data.substring(byteBuffCursor, byteBuffCursor += AppConstant.LEN_TransCode));
        header.setSpacer1(' ');

        byteBuffCursor += 1;

        header.setCounter(data.substring(byteBuffCursor, byteBuffCursor += AppConstant.LEN_Counter));
        header.setSpacer2(' ');

        byteBuffCursor += 1;

        header.setDate(data.substring(byteBuffCursor, byteBuffCursor += AppConstant.LEN_Date));
        header.setSpacer3(' ');

        byteBuffCursor += 1;

        header.setTime(data.substring(byteBuffCursor, byteBuffCursor += AppConstant.LEN_Time));
        header.setTrailer(data.substring(byteBuffCursor, byteBuffCursor += AppConstant.LEN_Trailer));

        return header;
    }

    public static IDModel readIDFile(ByteBuffer byteBuffer, String data, int index){
        Scanner scanEof = new Scanner(data); /* Check if end of file */
        IDModel model = new IDModel();

        /* If end of file or IA structure starts with models.Footer identifier */
        if (!scanEof.hasNext() || data.substring(byteBuffCursor,
                byteBuffCursor + AppConstant.LEN_FooterIdent).equals(
                "FOOT>>")) {
//            breakLoop = true;
            return null;
        }

        String transId = data.substring(byteBuffCursor, byteBuffCursor + AppConstant.LEN_TransID);
        if(transId.compareTo("ID") != 0){
            byteBuffCursor -= 1;
        }
        model.setTransID(data.substring(byteBuffCursor, byteBuffCursor += AppConstant.LEN_TransID));
        model.setAttemptCount( (char) ((byte) byteBuffer.getChar()));
        byteBuffCursor++;
        model.setDateTime(data.substring(byteBuffCursor, byteBuffCursor += AppConstant.LEN_DateTime));

        int schedule = byteBuffer.getInt(byteBuffCursor);
        model.setScheduleID(schedule);
        byteBuffCursor += 4;

        int item = byteBuffer.getInt(byteBuffCursor);
        model.setItemID(item);
        byteBuffCursor += 4;

        byteBuffCursor++;

        // Check error reading
        boolean isInvalid = false;
        char cmp = data.substring(byteBuffCursor,byteBuffCursor+1).charAt(0);
        while (cmp >= '0' && cmp <= '9') {
            isInvalid = true;
            byteBuffCursor -= 1;
            cmp = data.substring(byteBuffCursor,byteBuffCursor+1).charAt(0);
        }
        if (schedule<=0 || item <=0) isInvalid =true;
//        if(index==3) byteBuffCursor += 1;

        if (isInvalid) {
            return null;
        }




//        System.out.println(model.getTransID());
//        System.out.println(model.getAttemptCount());
//        System.out.println(model.getDateTime());
//        System.out.println(model.getScheduleID());
//        System.out.println(model.getItemID());
        return model;
    }

    private static void writeToUnprocessed(IDModel model, FileChannel unprocessed){
        byte[] buffer;
        ByteBuffer sizeBuffer = ByteBuffer.allocate(0x100000);
        sizeBuffer.order(ByteOrder.LITTLE_ENDIAN);

        buffer = model.getTransID().getBytes();
        sizeBuffer.put(buffer);

        byte transAttempt = (byte) model.getAttemptCount();
        sizeBuffer.put(transAttempt);

        buffer = model.getDateTime().getBytes();
        sizeBuffer.put(buffer);

        sizeBuffer.putInt(model.getScheduleID());

        sizeBuffer.putInt(model.getItemID());

        byte nullByte = (byte) model.getREC_NULL();
        sizeBuffer.put(nullByte);

        sizeBuffer.flip();
        try {
            unprocessed.write(sizeBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Footer readFooter(String data){
        Footer footer = new Footer();
        footer.setFooterIdent((data.substring(byteBuffCursor, byteBuffCursor += AppConstant.LEN_FooterIdent)));
        footer.setTransCode((data.substring(byteBuffCursor, byteBuffCursor += AppConstant.LEN_TransCode)));
        footer.setSpacer1(' ');

        byteBuffCursor += 1;

        footer.setCounter((data.substring(byteBuffCursor, byteBuffCursor += AppConstant.LEN_Counter)));
        footer.setSpacer2(' ');

        byteBuffCursor += 1;

        footer.setDate((data.substring(byteBuffCursor, byteBuffCursor += AppConstant.LEN_Date)));
        footer.setSpacer3(' ');

        byteBuffCursor += 1;

        footer.setTime((data.substring(byteBuffCursor, byteBuffCursor += AppConstant.LEN_Time)));
        footer.setSpacer4(' ');

        byteBuffCursor += 1;

        footer.setRecordCount((data.substring(byteBuffCursor, byteBuffCursor += AppConstant.LEN_RecordCount)));
        footer.setSpacer5(' ');

        byteBuffCursor += 1;

        footer.setRowText((data.substring(byteBuffCursor, byteBuffCursor += AppConstant.LEN_RowsText)));
        footer.setTrailer((data.substring(byteBuffCursor, byteBuffCursor += AppConstant.LEN_Trailer)));

        System.out.println(footer.getFooterIdent());


        return footer;
    }
//
private static List<Object> readIDFile(String filePath){
    List<Object> fileContent = new ArrayList<>();
    FileInputStream fileInputStream;
    ByteBuffer byteBuffer = ByteBuffer.allocate(0x10000);
    try {
        byteBuffCursor = 0;
        breakLoop = false;
        fileInputStream = new FileInputStream(filePath);
        FileChannel fileChannel = fileInputStream.getChannel();
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        fileChannel.read(byteBuffer);
        String data = new String(byteBuffer.array());
        fileContent.add(readHeader(data));
        int i = 0;
        do {
            IDModel itreEntity = readIDFile(byteBuffer, data, i);
            if (itreEntity != null) {
                System.out.println("Index: "+i);
                i++;
                fileContent.add(itreEntity);
            }
        } while (!breakLoop);

        fileContent.add(readFooter(data));
        byteBuffer.flip();
    } catch (FileNotFoundException e) {
        System.out.println("FileNotFoundException readFileAsString(): " + e.getMessage());
    } catch (IOException e) {
        System.out.println("IOException readFileAsString(): " + e.getMessage());
    }

    return fileContent;
}

    public static void writeHeaderwithTransCode(FileChannel unprocessed, String TransCode)
            throws FileNotFoundException {

//      FileOutputStream test = new FileOutputStream(filename);
//      FileChannel file= test.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(0x10000);
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);

        /* Get the date and time */
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("yyyyMdd");
        DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("HH:mm:ss");

        Header headerModel = new Header();
        headerModel.setHeaderIdent("HEAD>>");
        headerModel.setTrailer("<<\0");
        headerModel.setDate(localDateTime.format(formatDate));
        headerModel.setTime(localDateTime.format(formatTime));
//		headerModel.setTransCode("FN");
        headerModel.setTransCode(TransCode);
        headerModel.setCounter(String.valueOf(1));

        try {

            /* Populate the header */
            String header = String.format("%5s%2s %6s %8s %8s%3s", headerModel.getHeaderIdent(),
                    headerModel.getTransCode(), headerModel.getCounter(), headerModel.getDate(), headerModel.getTime(),
                    headerModel.getTrailer());

            byte[] writeHeader = header.getBytes();
            byteBuffer.put(writeHeader);

            byteBuffer.flip();

            /* Write header to file */
            unprocessed.write(byteBuffer);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void writeFooter(FileChannel unprocessed) throws FileNotFoundException {

//        FileOutputStream test = new FileOutputStream(filename);
//        FileChannel file= test.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(0x10000);
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);

        /* Get the date and time */
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("yyyyMdd");
        DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("HH:mm:ss");

        Footer footerModel = new Footer();
//		footerModel.setTransCode("FN");
        footerModel.setTransCode("ID");
        footerModel.setCounter(String.valueOf(1));
        footerModel.setRecordCount(String.valueOf(1));
        footerModel.setDate(localDateTime.format(formatDate));
        footerModel.setTime(localDateTime.format(formatTime));
        footerModel.setFooterIdent("FOOT>>");
        footerModel.setRowText("ROWS");
        footerModel.setTrailer("<<\0");

        try {

            /* Populate the footer */
            String footer = String.format("%5s%2s %6s %8s %8s %9s %4s%3s", footerModel.getFooterIdent(),
                    footerModel.getTransCode(), footerModel.getCounter(), footerModel.getDate(), footerModel.getTime(),
                    footerModel.getRecordCount(), footerModel.getRowText(), footerModel.getTrailer());

            byte[] writeFooter = footer.getBytes();
            byteBuffer.put(writeFooter);

            byteBuffer.flip();

            /* Write footer to file */
            unprocessed.write(byteBuffer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {

        String data = "";
        FileInputStream fileInputStream = new FileInputStream(new File(FILE_PATH_OUTPUT));
        ByteBuffer byteBuffer = ByteBuffer.allocate(0x10000);
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        FileChannel fileChannel = fileInputStream.getChannel();
        fileChannel.read(byteBuffer);
        data = new String(byteBuffer.array());

        Header header = readHeader(data);
        System.out.println(header.getTransCode());
        System.out.println(header.getCounter());
        System.out.println(header.getDate());
        System.out.println(header.getTime());
        System.out.println(header.getTrailer());
        int i=0;
        while (true){
            try {
                IDModel model = readIDFile(byteBuffer, data, i++);
                System.out.println(model.getTransID());
                System.out.println(model.getDateTime());
                System.out.println(model.getAttemptCount());
                System.out.println(model.getScheduleID());
                System.out.println(model.getItemID());
            }catch (Exception e){
                break;
            }
        }

        Footer footer = readFooter(data);
        System.out.println(footer.getFooterIdent());
        System.out.println(footer.getCounter());
        System.out.println(footer.getRecordCount());
        System.out.println(footer.getRowText());
        System.out.println(footer.getTime());
        System.out.println(footer.getDate());

        /* Line of codes below is for file reading */

//        FileOutputStream fileOutputStream = new FileOutputStream(new File(FILE_PATH_OUTPUT));
//        FileChannel outputChannel = fileOutputStream.getChannel();


//        models.Header header = new models.Header();
//        header.setHeaderIdent("HEAD>>");
//        header.setDate("20220517");
//        header.setTime("21:15:08");
//        header.setTransCode("ID");
//        header.setSpacer1(' ');
//        header.setSpacer2(' ');
//        header.setSpacer3(' ');
//        header.setTrailer("<<\0");
//        header.setCounter("0");
//
//        List<models.IDModel> idModels = utils.DataGenerator.initIDModelArrayList();
//
//        models.Footer footer = new models.Footer();
//        footer.setCounter("0");
//        footer.setFooterIdent("Foot>>");
//        footer.setDate("20220517");
//        footer.setRecordCount("000000830");
//        footer.setTime("21:15:08");
//        footer.setSpacer1(' ');
//        footer.setRowText("");
//        footer.setSpacer2(' ');
//        footer.setSpacer3(' ');
//        footer.setSpacer4(' ');
//        footer.setSpacer5(' ');
//
//        writeHeaderwithTransCode(outputChannel, "ID");
//        for (models.IDModel model: idModels) {
//            writeToUnprocessed(model, outputChannel);
//        }
//        writeFooter(outputChannel);
    }
}
