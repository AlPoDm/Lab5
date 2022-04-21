import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;


public class UI extends JFrame{
    final JTextField putKey1 = new JTextField("Ключ ",10);
    final JTextField putKey = new JTextField("Ключ ",10);
    final JTextField getKey = new JTextField("Ключ ",10);
    final JTextField delKey = new JTextField("Ключ ",10);
    final JTextField putValue = new JTextField("Значение ",30);
    final JButton putButton = new JButton("Добавить");
    final JButton getButton = new JButton("Найти");
    final JButton delButton = new JButton("Удалить");
    final JLabel putStatus = new JLabel("Введите ключ и значение");
    final JLabel getStatus = new JLabel("Введите ключ для поиска записи");
    final JLabel delStatus = new JLabel("Введите ключ для удаления записи");
    public myMap myMainMap = new myMap(20);

    public UI () {
        super("Lab3 RPS");
        this.setBounds(300,200,350,200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JTabbedPane operationSelect = new JTabbedPane();

        Container putContainer = new JPanel();
        putContainer.setLayout(new GridLayout(5,10,2,2));
        putKey.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e) {
                if (putKey.getText().equals("Ключ ")) putKey.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (putKey.getText().equals("")) putKey.setText("Ключ ");
            }
        });
        putValue.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e) {
                if (putValue.getText().equals("Значение ")) putValue.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (putValue.getText().equals("")) putValue.setText("Значение ");
            }
        });
        putContainer.add(putKey);
        putContainer.add(putValue);
        putButton.addActionListener(new ButtonEventListinerPut ());
        putContainer.add(putButton);
        putContainer.add(putStatus);

        Container getContainer = new JPanel();
        getContainer.setLayout(new GridLayout(5,10,2,2));
        getKey.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e) {
                if (getKey.getText().equals("Ключ ")) getKey.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (getKey.getText().equals("")) getKey.setText("Ключ ");
            }
        });
        getContainer.add(getKey);
        getButton.addActionListener(new ButtonEventListinerGet ());
        getContainer.add(getButton);
        getContainer.add(getStatus);

        Container delContainer = new JPanel();
        delContainer.setLayout(new GridLayout(5,10,2,2));
        delKey.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e) {
                if (delKey.getText().equals("Ключ ")) delKey.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (delKey.getText().equals("")) delKey.setText("Ключ ");
            }
        });
        delContainer.add(delKey);
        delButton.addActionListener(new ButtonEventListinerDel ());
        delContainer.add(delButton);
        delContainer.add(delStatus);

        operationSelect.addTab("Добавление", putContainer);
        operationSelect.addTab("Поиск", getContainer);
        operationSelect.addTab("Удаление", delContainer);
        this.add(operationSelect);
    }

    class ButtonEventListinerPut implements ActionListener{
        public void actionPerformed (ActionEvent e) {
            myMainMap.put(putKey.getText(),putValue.getText());
            putStatus.setText("По ключу \"" + putKey.getText() + "\" добавлено значение \"" + putValue.getText() + "\"");
        }
    }

    class ButtonEventListinerGet implements ActionListener{
        public void actionPerformed (ActionEvent a) {
            getStatus.setText("Значение: "  + myMainMap.get(getKey.getText()));
        }
    }

    class ButtonEventListinerDel implements ActionListener{
        public void actionPerformed (ActionEvent z) {
            delStatus.setText( myMainMap.remove(delKey.getText()));
        }
    }
}
