package Problem48;
/*
 * ���ܱ��̳е��ࣨ��������final�ؼ��֣�
 */
public class FinalClass {
    public static FinalClass getInstance() {//ͨ������public�ľ�̬�������������ͷ����ʵ��
        return new FinalClass();
    }

    private FinalClass() {		//˽�л����캯��
    }
}
