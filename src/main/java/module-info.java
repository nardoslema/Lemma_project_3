module com.example.lemma_project_3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lemma_project_3 to javafx.fxml;
    exports com.example.lemma_project_3;
}