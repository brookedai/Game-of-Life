package controller;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.Board;
import model.Cell;

/*
 cred: https://stackoverflow.com/questions/29464411/how-to-create-tabs-dynamically-in-javafx-using-fxml
       https://netopyr.com/2012/06/14/using-the-javafx-animationtimer/
       https://stackoverflow.com/questions/30146560/how-to-change-animationtimer-speed
*/

public class MainController {
    private final int CELL_SIZE = 10;

    private Rectangle[][] boardView;
    private Board board;

    @FXML
    private Pane pane;
    @FXML
    private TextField rowField;
    @FXML
    private TextField colField;

    private void initialize() {
        board = new Board();
    }

    @FXML
    public void createBoard() {
        int rows = Integer.parseInt(rowField.getCharacters().toString());
        int cols = Integer.parseInt(colField.getCharacters().toString());

        board = new Board(rows, cols);
        boardView = new Rectangle[cols][rows];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                final Rectangle rect = new Rectangle(CELL_SIZE, CELL_SIZE);
                final int[] row = {r};
                final int[] col = {c};

                rect.setOnMousePressed(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        if (board.getCell(row[0], col[0]).isAlive()) {
                            rect.setFill(Color.rgb(255,255,255));
                        } else {
                            rect.setFill(Color.rgb(0,0,0));
                        }
                        Cell c = board.getCell(row[0], col[0]);
                        c.setAlive(!c.isAlive());
                    }
                });
                boardView[c][r] = rect;
                pane.getChildren().add(rect);
                rect.setX(CELL_SIZE*c);
                rect.setY(CELL_SIZE*r);
                rect.setFill(Color.rgb(255, 255, 255));
                rect.setStroke(Color.rgb(200, 200, 200));
            }
        }
    }

    @FXML
    public void run() {
        new AnimationTimer() {
            private long lastUpdate = 0;
            @Override
            public void handle(long now) {
                if (now - lastUpdate >= 70000000) {
                    board.update();
                    updateBoardView();
                    lastUpdate = now;
                }
            }
        }.start();
    }

    private void updateBoardView() {
        for (int c = 0; c < boardView.length; c++) {
            for (int r = 0; r < boardView[c].length; r++) {
                if (board.getCell(r, c).isAlive()) {
                    boardView[c][r].setFill(Color.rgb(0,0,0));
                } else {
                    boardView[c][r].setFill(Color.rgb(255,255,255));
                }
            }
        }
    }



}
