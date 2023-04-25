import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//reference : https://stackoverflow.com/questions/20526917/load-arraylist-data-into-jtable
//          : https://www.javatpoint.com/java-jtable

public class DisplayGUI {

//strarting page
    void homeScreen(){
        JFrame frame=new JFrame("WELCOME PAGE");
        try {
            frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("f2.jpg")).getScaledInstance(700, 400, Image.SCALE_SMOOTH))));
        } catch (IOException e) {
            e.printStackTrace();
        }
//title
        JLabel label = new JLabel("FORMULA1 CAR CHAMPIONSHIP - 2021");
        label.setBounds(75,150, 600,70);
        Font font = new Font("Brush Script MT", Font.BOLD,31);
        label.setFont(font);
        label.setForeground(Color.WHITE);

//button
        JButton button=new JButton("VIEW DRIVER TABLES ---->");
        button.setBounds(200,230,300,40);
        Font btnFont = new Font("Arial", Font.BOLD,14);
        button.setFont(btnFont);
        button.setBackground(Color.WHITE);
        button.setFocusPainted(false);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                displayDriverTable();
            }
        });

        frame.add(label);
        frame.add(button);
        frame.setSize(700,400);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }


    void displayDriverTable(){

        JFrame frame=new JFrame();
        frame.setLayout(new BorderLayout());

        ArrayList<Formula1Driver> driverList = Formula1ChampionshipManager.getDriverList(); //Driver ArrayList from Formula1ChampionShipManager
        Collections.sort(driverList,new PointsComparator());


//set column names
        String[] columnName = {"Driver Name","Constructor Team ","No.of 1st Position",
                               "No.of 2nd Position", "No.of 3rd Position", "Total Points", "No.of Games"};
        DefaultTableModel tableModel = new DefaultTableModel(columnName, 0);
        JTable table = new JTable(tableModel);

//set values for rows

        addDataToTable(driverList,tableModel);
//center alignment for columns
        DefaultTableCellRenderer render = new DefaultTableCellRenderer();
        render.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        for(int i=0; i < table.getColumnCount(); i++){
            table.getColumnModel().getColumn(i).setCellRenderer(render);
            table.getColumnModel().getColumn(i).setPreferredWidth(100);
        }

        JLabel label = new JLabel("POINTS TABLE");

        JButton button1 =new JButton("SORT POINTS");
        button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                table.setAutoCreateRowSorter(true);
                ((DefaultRowSorter)table.getRowSorter()).toggleSortOrder(5);  //by total points

            }
        });


        JButton button2 =new JButton("SORT 1ST POSITIONS");
        button2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                table.setAutoCreateRowSorter(true);
                DefaultRowSorter sorter = ((DefaultRowSorter) table.getRowSorter());
                sorter.setComparator(2, new PositionComparator());  //by 1st positions
            }
        });

        JPanel buttonPane = new JPanel(new BorderLayout());
        JPanel bottomPane = new JPanel(new FlowLayout(FlowLayout.CENTER));

        bottomPane.add(button1);
        bottomPane.add(button2);
        buttonPane.add(bottomPane, BorderLayout.CENTER);

        table.getTableHeader().setReorderingAllowed(false);
        JScrollPane scroller=new JScrollPane(table);
        JRootPane root = new JRootPane();
        root.add(table);

        frame.add(root);
        frame.add(table.getTableHeader(), BorderLayout.NORTH);
        frame.add(table,BorderLayout.CENTER);
        frame.add(buttonPane, BorderLayout.SOUTH);

        frame.setTitle("FORMULA1 CAR CHAMPIONSHIP POINTS TABLE - 2021");
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }

    void addDataToTable(ArrayList<Formula1Driver> driverList , DefaultTableModel tableModel){

        for (Formula1Driver formula1Driver : driverList) {
            String nameOfDriver = formula1Driver.getNameOfDriver();
            String constructorTeamName = formula1Driver.getConstructorTeamName();
            int noOfFirstPosition = formula1Driver.getNoOfFirstPosition();
            int noOfSecondPosition = formula1Driver.getNoOfSecondPosition();
            int noOfThirdPosition = formula1Driver.getNoOfThirdPosition();
            int totalPoint = formula1Driver.getTotalPoint();
            int noOfParticipatedGames = formula1Driver.getNoOfParticipatedGames();

            //table rows
            Object[] row = {nameOfDriver, constructorTeamName, noOfFirstPosition, noOfSecondPosition, noOfThirdPosition, totalPoint,
                    noOfParticipatedGames};

            tableModel.addRow(row);
        }

    }
}