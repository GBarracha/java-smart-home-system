import javafx.scene.control.Slider;

/**
 * Esta classe permite criar um ValueSlider, com diferentes valores para ser aplicado.
 *
 * @author Gonçalo Barracha, Rodrigo Cardoso
 * @version 28/06/2024
 */
public class TemperatureSlider extends Slider
{
    /**
     * Construtor da classe TemperatureSlider, este slider vai permitir atualizar a temperatura
     * pretendida pelo utilizador através de um slider com vários valores.
     */
    public TemperatureSlider() {
        setMin(Temperatura.MIN);
        setMax(Temperatura.MAX);
        setShowTickLabels(true);
        setShowTickMarks(true);
        setMajorTickUnit(10);
    }
}
