package utils;

import models.IDModel;

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
}
