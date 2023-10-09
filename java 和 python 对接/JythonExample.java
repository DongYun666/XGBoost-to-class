import org.python.core.PyFunction;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

public class JythonExample {
    public static void main(String[] args) {
        // 创建 PythonInterpreter 对象
        PythonInterpreter interpreter = new PythonInterpreter();

        // 加载训练好的 Python 模型
        String code = "import joblib\n" +
                      "model = joblib.load('model.pkl')\n";

        interpreter.exec(code);

        // 获取模型对象
        PyObject model = interpreter.get("model");

        // 定义测试数据，注意要与模型期望的输入格式相匹配
        PyObject testData = new PyObject(new double[]{1.0, 2.0, 3.0});

        // 使用模型进行预测
        PyObject result = model.invoke("predict", testData);

        // 将 Python 返回结果转换为 Java 类型
        double prediction = result.asDouble();

        // 输出预测结果
        System.out.println("Prediction: " + prediction);
    }
}
