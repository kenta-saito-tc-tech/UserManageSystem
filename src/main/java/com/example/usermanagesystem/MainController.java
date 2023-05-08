package com.example.usermanagesystem;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController {
    /**
     * ユーザー追加
     */
    @FXML
    private ComboBox addCompany;
    @FXML
    private TextArea addName;
    @FXML
    private TextArea addScore;
    @FXML
    private Button addUser;
    /**
     * ユーザー編集
     */
    @FXML
    private ComboBox changeCompany;
    @FXML
    private TextArea changeName;
    @FXML
    private TextArea changeScore;
    @FXML
    private Button deleteUser;
    @FXML
    private Button changeUser;
    /**
     * 一覧表示
     */
    @FXML
    private TableView allView;
    @FXML
    private TableColumn idView;
    @FXML
    private TableColumn companyView;
    @FXML
    private TableColumn nameView;
    @FXML
    private TableColumn scoreView;

    @FXML
    public void initialize() {
        //TableViewの設定
        idView.setCellValueFactory(new PropertyValueFactory<Person, Integer>("id"));
        companyView.setCellValueFactory(new PropertyValueFactory<Person, String>("company"));
        nameView.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
        scoreView.setCellValueFactory(new PropertyValueFactory<Person, Integer>("score"));

        //ComboBoxの初期設定
        addCompany.getItems().addAll("株式会社A", "株式会社B", "株式会社C");
        changeCompany.getItems().addAll(addCompany.getItems());

        //tableViewの初期表示二件
        allView.getItems().add(new Person(allView.getItems().size() + 1, "株式会社A", "AAA", 10));
        allView.getItems().add(new Person(allView.getItems().size() + 1, "株式会社B", "BBB", 20));

        // TableViewのセルがクリックされたときの処理
        allView.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) { // クリック回数が1回の場合
                Person selectedPerson = (Person) allView.getSelectionModel().getSelectedItem();
                if (selectedPerson != null) {
                    changeCompany.setValue(selectedPerson.companyProperty().getValue());
                    changeName.setText(selectedPerson.nameProperty().getValue());
                    changeScore.setText(selectedPerson.scoreProperty().getValue().toString());

                    //削除ボタンクリック時処理
                    deleteUser.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            allView.getItems().remove(selectedPerson);
                            // 残りのデータのIDを変更する
                            ObservableList<Person> list = allView.getItems();
                            list.remove(selectedPerson);
                            selectedPerson.deleteAll();
                            // 残りのデータのIDを変更する
                            for (int i = 0; i < list.size(); i++) {
                                list.get(i).setId(i + 1);
                            }
                        }
                    });

                    //更新ボタンクリック時処理
                    changeUser.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            // 選択された行の値を変更する
                            selectedPerson.setCompany(changeCompany.getValue().toString());
                            selectedPerson.setName(changeName.getText());
                            selectedPerson.setScore(Integer.parseInt(changeScore.getText()));
                            // TableViewに変更を反映する
                            allView.refresh();
                        }
                    });

                }
            }
        });
    }

    /**
     * 追加ボタンクリック時処理
     */
    @FXML
    public void addUserBtn() {
        // サンプルデータを1行追加
        //allView.getItems().add(new Person(1, "T&C", "斎藤", 100));

        allView.getItems().add(new Person(allView.getItems().size() + 1,
                addCompany.getValue().toString(),
                addName.getText(),
                Integer.parseInt(addScore.getText())));
    }
}