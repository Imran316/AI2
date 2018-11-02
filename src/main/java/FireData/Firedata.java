package FireData;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutionException;

public class Firedata {
    com.google.cloud.firestore.Firestore db;
    public Firedata() throws IOException {

            FileInputStream serviceAccount = new FileInputStream("./time.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    //.setDatabaseUrl("https://timetable-1d3e6.firebaseio.com")
                    .build();

        try{
            FirebaseApp.getInstance();
        }
        catch (IllegalStateException e)
        {
            //Firebase not initialized automatically, do it manually
            FirebaseApp.initializeApp(options);
        }

            db = FirestoreClient.getFirestore();

    }
    public static void main(String[] args) throws IOException , InterruptedException, ExecutionException {
        Firedata firedata = new Firedata();
        firedata.addProfessor("1","Arvind","12345");
        firedata.addProfessor("2","Imran","12345");
        firedata.addProfessor("3","Laraib","12345");
        firedata.retriveProfessor();
        /*ProfessorInfo professorInfo = new ProfessorInfo("3", "Imran", "9370088262");
        ArrayList<ProfessorInfo> prof = new ArrayList<>();
        prof.add(new ProfessorInfo("1", "Imran", "9370088262"));
        prof.add(new ProfessorInfo("2", "Arvind", "9370088262"));
        prof.add(new ProfessorInfo("3", "Khan", "9370088262"));
        prof.add(new ProfessorInfo("4", "BADWAR", "9370088262"));

        IntStream.range(0,prof.size()).forEach(m -> {
            ApiFuture<WriteResult> future= db.collection("sampleData").document(prof.get(m).getProfName())
                    .set(prof.get(m));
            try {
                future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
*/

        //HashMap<String, String> quote = getQuote.getQuoteFromHTTP();

        /*DocumentReference docRef = db.collection("sampleData").document("inspiration");
        ApiFuture<DocumentSnapshot> future = docRef.get();
        DocumentSnapshot document = future.get();
        if (document.exists()) {
            // convert document to POJO
            String quoteText = document.getString("quote");
            String authorText = document.getString("author");
            System.out.println(quoteText+"   "+  authorText);
        } else {
            System.out.println("No such document!");
        }
        //System.out.println("Successfully updated at: "+ future.get().getUpdateTime());*/
        System.out.println("Hello");
    }

    public void addProfessor(String id, String name, String mobNo) throws InterruptedException, ExecutionException{
        ProfessorInfo professorInfo = new ProfessorInfo(id, name, mobNo);

        ApiFuture<WriteResult> future= db.collection("PROFESSOR").document(professorInfo.getProfName())
                .set(professorInfo);
        future.get();

        System.out.println(professorInfo.getProfName()+"  updated at "+future.get().getUpdateTime());
    }

    public ArrayList<ProfessorInfo> retriveProfessor() throws InterruptedException, ExecutionException{
        ApiFuture<QuerySnapshot> future = db.collection("PROFESSOR").get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        ArrayList<ProfessorInfo> profs = new ArrayList<>();

        for (DocumentSnapshot document : documents) {
            profs.add(document.toObject(ProfessorInfo.class));
            System.out.println(document.getId() + " => " + document.toObject(ProfessorInfo.class));
        }
        return profs;
    }

    public void deleteProfessor(String name){
        ApiFuture<WriteResult> future =  db.collection("PROFESSOR").document(name).delete();
        try {
            future.get();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void addSE_SUBJECT(String subName, String profName, int noPerWeek, boolean isLab) throws InterruptedException, ExecutionException{


        SubjectInfo subjectInfo = new SubjectInfo(subName, profName, noPerWeek, isLab);

        ApiFuture<WriteResult> future= db.collection("SE_SUBJECT").document(subjectInfo.getSubjectName())
                .set(subjectInfo);
        future.get();

        System.out.println(subjectInfo.getSubjectName()+"  updated at "+future.get().getUpdateTime());
    }

    public void deleteSE_SUBJECT() throws InterruptedException, ExecutionException{
        ApiFuture<QuerySnapshot> apiFuture = db.collection("SE_SUBJECT").get();
        List<QueryDocumentSnapshot> documents = apiFuture.get().getDocuments();
        for (DocumentSnapshot document : documents) {
            ApiFuture<WriteResult> future =  db.collection("SE_SUBJECT").document(document.getId()).delete();
            try {
                future.get();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
            System.out.println(document.getId() + " => " + document.toObject(ProfessorInfo.class));
        }
    }

    public void addTE_SUBJECT(String subName, String profName, int noPerWeek, boolean isLab) throws InterruptedException, ExecutionException{


        SubjectInfo subjectInfo = new SubjectInfo(subName, profName, noPerWeek, isLab);

        ApiFuture<WriteResult> future= db.collection("TE_SUBJECT").document(subjectInfo.getSubjectName())
                .set(subjectInfo);
        future.get();

        System.out.println(subjectInfo.getSubjectName()+"  updated at "+future.get().getUpdateTime());
    }

    public void deleteTE_SUBJECT() throws InterruptedException, ExecutionException{
        ApiFuture<QuerySnapshot> apiFuture = db.collection("TE_SUBJECT").get();
        List<QueryDocumentSnapshot> documents = apiFuture.get().getDocuments();
        for (DocumentSnapshot document : documents) {
            ApiFuture<WriteResult> future =  db.collection("TE_SUBJECT").document(document.getId()).delete();
            try {
                future.get();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
            System.out.println(document.getId() + " => " + document.toObject(ProfessorInfo.class));
        }
    }

    public void addBE_SUBJECT(String subName, String profName, int noPerWeek, boolean isLab) throws InterruptedException, ExecutionException{

         SubjectInfo subjectInfo = new SubjectInfo(subName, profName, noPerWeek, isLab);

        ApiFuture<WriteResult> future= db.collection("BE_SUBJECT").document(subjectInfo.getSubjectName())
                .set(subjectInfo);
        future.get();

        System.out.println(subjectInfo.getSubjectName()+"  updated at "+future.get().getUpdateTime());
    }

    public void deleteBE_SUBJECT() throws InterruptedException, ExecutionException{
        ApiFuture<QuerySnapshot> apiFuture = db.collection("BE_SUBJECT").get();
        List<QueryDocumentSnapshot> documents = apiFuture.get().getDocuments();
        for (DocumentSnapshot document : documents) {
            ApiFuture<WriteResult> future =  db.collection("BE_SUBJECT").document(document.getId()).delete();
            try {
                future.get();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
            System.out.println(document.getId() + " => " + document.toObject(ProfessorInfo.class));
        }
    }

    public ArrayList<SubjectInfo> retriveSE_SUBJECT() throws InterruptedException, ExecutionException{
        ApiFuture<QuerySnapshot> future = db.collection("SE_SUBJECT").get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        ArrayList<SubjectInfo> profs = new ArrayList<>();

        for (DocumentSnapshot document : documents) {
            profs.add(document.toObject(SubjectInfo.class));
            System.out.println(document.getId() + " => " + document.toObject(ProfessorInfo.class));
        }
        return profs;
    }

    public ArrayList<SubjectInfo> retriveTE_SUBJECT() throws InterruptedException, ExecutionException{
        ApiFuture<QuerySnapshot> future = db.collection("TE_SUBJECT").get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        ArrayList<SubjectInfo> profs = new ArrayList<>();

        for (DocumentSnapshot document : documents) {
            profs.add(document.toObject(SubjectInfo.class));
            System.out.println(document.getId() + " => " + document.toObject(ProfessorInfo.class));
        }
        return profs;
    }

    public ArrayList<SubjectInfo> retriveBE_SUBJECT() throws InterruptedException, ExecutionException{
        ApiFuture<QuerySnapshot> future = db.collection("BE_SUBJECT").get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        ArrayList<SubjectInfo> profs = new ArrayList<>();

        for (DocumentSnapshot document : documents) {
            profs.add(document.toObject(SubjectInfo.class));
            System.out.println(document.getId() + " => " + document.toObject(ProfessorInfo.class));
        }
        return profs;
    }

    public void addSETimetable(String day, ArrayList<String> time, ArrayList<String> praTime, ArrayList<String> subProf, ArrayList<String> labProf) throws ExecutionException, InterruptedException {

        UploadTImetable uploadTImetable = new UploadTImetable(day, time, praTime,subProf,labProf);

        ApiFuture<WriteResult> future= db.collection("SE_TIMETABLE").document(uploadTImetable.getDay())
                .set(uploadTImetable);
        future.get();

        System.out.println(uploadTImetable.getDay()+"  updated at "+future.get().getUpdateTime());
    }

    public void addTETimetable(String day, ArrayList<String> time, ArrayList<String> praTime, ArrayList<String> subProf, ArrayList<String> labProf) throws ExecutionException, InterruptedException {

        UploadTImetable uploadTImetable = new UploadTImetable(day, time, praTime,subProf,labProf);

        ApiFuture<WriteResult> future= db.collection("TE_TIMETABLE").document(uploadTImetable.getDay())
                .set(uploadTImetable);
        future.get();

        System.out.println(uploadTImetable.getDay()+"  updated at "+future.get().getUpdateTime());
    }

    public void addBETimetable(String day, ArrayList<String> time, ArrayList<String> praTime, ArrayList<String> subProf, ArrayList<String> labProf) throws ExecutionException, InterruptedException {

        UploadTImetable uploadTImetable = new UploadTImetable(day, time, praTime,subProf,labProf);

        ApiFuture<WriteResult> future= db.collection("BE_TIMETABLE").document(uploadTImetable.getDay())
                .set(uploadTImetable);
        future.get();

        System.out.println(uploadTImetable.getDay()+"  updated at "+future.get().getUpdateTime());
    }

    public ArrayList<UploadTImetable> retriveSE_Timetable() throws InterruptedException, ExecutionException{
        ApiFuture<QuerySnapshot> future = db.collection("SE_TIMETABLE").get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        ArrayList<UploadTImetable> profs = new ArrayList<>();

        for (DocumentSnapshot document : documents) {
            profs.add(document.toObject(UploadTImetable.class));
            System.out.println(document.getId() + " => " + document.toObject(UploadTImetable.class));
        }
        return profs;
    }

    public ArrayList<UploadTImetable> retriveTE_Timetable() throws InterruptedException, ExecutionException{
        ApiFuture<QuerySnapshot> future = db.collection("TE_TIMETABLE").get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        ArrayList<UploadTImetable> profs = new ArrayList<>();

        for (DocumentSnapshot document : documents) {
            profs.add(document.toObject(UploadTImetable.class));
            System.out.println(document.getId() + " => " + document.toObject(UploadTImetable.class));
        }
        return profs;
    }
    public ArrayList<UploadTImetable> retriveBE_Timetable() throws InterruptedException, ExecutionException{
        ApiFuture<QuerySnapshot> future = db.collection("BE_TIMETABLE").get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        ArrayList<UploadTImetable> profs = new ArrayList<>();

        for (DocumentSnapshot document : documents) {
            profs.add(document.toObject(UploadTImetable.class));
            System.out.println(document.getId() + " => " + document.toObject(UploadTImetable.class));
        }
        return profs;
    }


    public void addProfessorTimetable(String professorName, String day, ArrayList<String> time, ArrayList<String> praTime, ArrayList<String> subProf, ArrayList<String> labProf) throws ExecutionException, InterruptedException {

        UploadTImetable uploadTImetable = new UploadTImetable(day, time, praTime,subProf,labProf);

        ApiFuture<WriteResult> future= db.collection(professorName).document(uploadTImetable.getDay())
                .set(uploadTImetable);
        future.get();

        System.out.println(uploadTImetable.getDay()+"  updated at "+future.get().getUpdateTime());
    }


}
