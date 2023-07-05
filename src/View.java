public class View {
    private String text;

    public View() {
        String text1 = "Введите Фамилия Имя Отчество датарождения номертелефона пол\n";
        text1 = text1 + "разделенные пробелом\n";
        text1 = text1 + "Формат данных:\n";
        text1 = text1 + "фамилия, имя, отчество - строки\n";
        text1 = text1 + "дата рождения - строка формата dd.mm.yyyy\n";
        text1 = text1 + "номер телефона - целое беззнаковое число\n";
        text1 = text1 + "пол - символ латиницей f или m\n";
        text1 = text1 + "----------------";

        this.text = text1;
    }
    public void print(){
        System.out.println(this.text);
    }
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
