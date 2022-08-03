package utils;

public class AppConstant {
    public static int LEN_DATE = 8;
    public static int LEN_DateTime = 14;
    public static int LEN_DateTime_DB = 19;
    public static int LEN_SDN = 4;
    public static int LEN_TransID = 2;
    public static int LEN_FORMTYPE = 3;
    public static int LEN_ScheduleID = 32;
    public static int LEN_ItemID = 20;
    public static int LEN_SchContactName = 70;
    public static int LEN_SchContactStatus = 40;
    public static int LEN_SchContactTel = 20;
    public static int LEN_SchContactFax = 20;
    public static int LEN_ScheduleNo = 18;
    public static int LEN_PolicyQCSNo = 16;
    public static int LEN_ClientName = 70;
    public static int LEN_OccName = 70;
    public static int LEN_Capacity = 20;
    public static int LEN_SDCDescID = 20;
    public static int LEN_Fq = 3;
    public static int LEN_HeaderIdent = 6; /* HEAD>> */
    public static int LEN_TransCode = 2;   /* TC */
    public static int LEN_Counter = 6;     /* CCCCCC */
    public static int LEN_Date = 8;        /* YYYY0M0D */
    public static int LEN_Time = 8;        /* HH:MM:SS */
    public static int LEN_Trailer = 3;     /* << followed by null */

    /* Define field lengths in file footer structure */

    public static int LEN_FooterIdent = 6; /* FOOT>> */
    public static int LEN_RecordCount = 9;/* NNNNNNNNN */
    public static int LEN_RowsText = 4;    /* " ROWS" */

    public static int LEN_PolicyType = 1;
    public static int LEN_SchedType = 1;
    public static int LEN_Discipline = 2;
    public static int LEN_SchReportElect = 1;
    public static int LEN_NextDate = 8;
    public static int LEN_SchStartDate = 8;
    public static int LEN_OccAddress1 = 30;
    public static int LEN_OccAddress2 = 30;
    public static int LEN_OccAddress3 = 30;
    public static int LEN_OccAddress4 = 30;
    public static int LEN_OccPostCodeOut = 4;
    public static int LEN_OccPostCodeIn = 3;
    public static int MAXLINE = 128;

    public static int LEN_ITM_SDC = 5;
    public static int LEN_ITM_DESC = 70;
    public static int LEN_CAPACITY = 20;
}
