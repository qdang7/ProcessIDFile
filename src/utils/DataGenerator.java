package utils;

import models.IDModel;
import models.SDModel;

import java.util.ArrayList;
import java.util.List;

public class DataGenerator {
    public static List<IDModel> initIDModelArrayList(){
        ArrayList<IDModel> idModels = new ArrayList<>();
        IDModel model1 = new IDModel();
        model1.setItemID(119500674);
        model1.setTransID("ID");
        model1.setScheduleID(4830);
        model1.setDateTime("20220517031000");
        model1.setAttemptCount('0');

        IDModel model2 = new IDModel();
        model2.setItemID(121440674);
        model2.setTransID("ID");
        model2.setScheduleID(4830);
        model2.setDateTime("20220517031000");
        model2.setAttemptCount('0');

        IDModel model3 = new IDModel();
        model3.setItemID(123150674);
        model3.setTransID("ID");
        model3.setScheduleID(4830);
        model3.setDateTime("20220517031000");
        model3.setAttemptCount('0');

        IDModel model4 = new IDModel();
        model4.setItemID(339260612);
        model4.setTransID("ID");
        model4.setScheduleID(9787);
        model4.setDateTime("20220517031000");
        model4.setAttemptCount('0');

        IDModel model5 = new IDModel();
        model5.setItemID(24963121);
        model5.setTransID("ID");
        model5.setScheduleID(10155);
        model5.setDateTime("20220517031000");
        model5.setAttemptCount('0');

        idModels.add(model1);
        idModels.add(model2);
        idModels.add(model3);
        idModels.add(model4);
        idModels.add(model5);

        return idModels;
    }

    public static SDModel sdModelFormator(SDModel input){
        String temp = "";
        int size = 0;

        temp = input.getSdcCapacity();
        size = AppConstant.LEN_Capacity - temp.length();
        for(int i=0; i<size; i++){
            temp += "\0";
        }
        input.setSdcCapacity(temp);

        temp = input.getSdcDesc();
        size = AppConstant.LEN_ITM_DESC - temp.length();
        for(int i=0; i<size; i++){
            temp += "\0";
        }
        input.setSdcDesc(temp);

        temp = input.getSdcGenericDesc();
        size = AppConstant.LEN_ITM_DESC - temp.length();
        for(int i=0; i<size; i++){
            temp += "\0";
        }
        input.setSdcGenericDesc(temp);


        return  input;
    }

    public static List<SDModel> initSDModels(){
        List<SDModel> sdModels = new ArrayList<>();
        String temp = "";
        int size = 0;

        SDModel model1 = new SDModel();
        model1.setTransID("SD");
        model1.setActionUID('I');
        model1.setDiscipline("LC");
        model1.setIuthDef(14.0);
        model1.setIuwkDef(0.0);
        model1.setSdc("L4357");
        model1.setDateTime("20090728212122");
        model1.setSdcCapacity("200 Ton");
        model1.setSdcDesc("Electric Overhead Travelling Crane");
        model1.setSdcGenericDesc("CRANES");

        model1.setNumRegBlocks(6);
        model1.setTransAttempt('0');
        model1.setRegBlocks("CR   12 DR   12 FA   12 MQ   12 OS   0  SB   0  ");

        sdModels.add(model1);

        SDModel model2 = new SDModel();
        model2.setTransID("SD");
        model2.setActionUID('I');
        model2.setDiscipline("PS");
        model2.setIuthDef(0.30000001192092895508);
        model2.setIuwkDef(0.30000001192092895508);
        model2.setSdc("B7000");
        model2.setDateTime("20090728212122");
        model2.setSdcCapacity("All");
        model2.setSdcDesc("Photograph");
        model2.setSdcGenericDesc("PHOTOGRAPH - PS");
        model2.setNumRegBlocks(1);
        model2.setTransAttempt('0');
        model2.setRegBlocks("PS0  0  DR   12 FA   12 MQ   12 OS   0  SB   0  ");
//
        sdModels.add(model2);
//
        SDModel model3 = new SDModel();
        model3.setTransID("SD");
        model3.setActionUID('I');
        model3.setDiscipline("EL");
        model3.setIuthDef(0.30000001192092895508);
        model3.setIuwkDef(0.0);
        model3.setSdc("E7003");
        model3.setDateTime("20090728212122");
        model3.setSdcCapacity("All");
        model3.setSdcDesc("Photograph");
        model3.setSdcGenericDesc("PHOTOGRAPH - EL");
        model3.setNumRegBlocks(1);
        model3.setTransAttempt('1');
        model3.setRegBlocks("HS   0  DR   12 FA   12 MQ   12 OS   0  SB   0  ");

        sdModels.add(model3);

        return sdModels;
    }
}
