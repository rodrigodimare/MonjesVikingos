package implementacion_class;

import org.junit.Before;
import org.junit.Test;

import static implementacion_class.VikingoC.EstadoVikingo.BERSERKER;
import static implementacion_class.VikingoC.EstadoVikingo.CALMADO;
import static implementacion_class.VikingoC.EstadoVikingo.COLERICO;
import static implementacion_class.VikingoC.EstadoVikingo.MUERTO;
import static implementacion_class.VikingoC.EstadoVikingo.NORMAL;
import static org.junit.Assert.assertEquals;

public class VikingoCTest {
    VikingoC vikingo1;
    VikingoC vikingo2;

    @Before
    public void crearVikingos() {
        // Arrange
        vikingo1 = new VikingoC("Ragnar");
        vikingo2 = new VikingoC("Rollo");
    }

    @Test
    public void cuandoEsAtacadoUnaVez_PasaAColerico() {
        // Act
        vikingo1.hacerDanio(vikingo2);

        // Assert
        assertEquals(vikingo2.getVida(), 90);
        assertEquals(vikingo2.getEstado(), COLERICO);
    }

    @Test
    public void cuandoEsAtacadoDosVeces_PasaABerserker() {
        // Act
        vikingo1.hacerDanio(vikingo2);
        vikingo1.hacerDanio(vikingo2);

        // Assert
        assertEquals(vikingo2.getVida(), 70);
        assertEquals(vikingo2.getEstado(), BERSERKER);
    }

    @Test
    public void cuandoEsAtacadoSiendoBerserker_SigueEnBerserker() {
        // Act
        vikingo1.hacerDanio(vikingo2);
        vikingo1.hacerDanio(vikingo2);
        vikingo1.hacerDanio(vikingo2);

        // Assert
        assertEquals(vikingo2.getVida(), 65);
        assertEquals(vikingo2.getEstado(), BERSERKER);
    }

    @Test
    public void cuandoEsAtacadoYLaVidaLlegaACero_MuereYDejaDeRecibirDanio() {
        // Act
        while (vikingo2.getVida() > 0) {
            vikingo1.hacerDanio(vikingo2);
        }

        vikingo1.hacerDanio(vikingo2);

        // Assert
        assertEquals(vikingo2.getVida(), 0);
        assertEquals(vikingo2.getEstado(), MUERTO);
    }

    @Test
    public void cuandoEstaNormalYMedita_PasaACalmadoYNoRecibeDanio() {
        // Act
        vikingo2.meditar();
        vikingo1.hacerDanio(vikingo2);

        // Assert
        assertEquals(vikingo2.getEstado(), CALMADO);
        assertEquals(vikingo2.getVida(), 100);
    }

    @Test
    public void cuandoEstaColericoYMedita_PasaANormal() {
        // Act
        vikingo1.hacerDanio(vikingo2);
        vikingo2.meditar();

        // Assert
        assertEquals(vikingo2.getEstado(), NORMAL);
        assertEquals(vikingo2.getVida(), 90);
    }

    @Test
    public void cuandoEstaBerserkerYMedita_PasaANormal() {
        // Act
        vikingo1.hacerDanio(vikingo2);
        vikingo1.hacerDanio(vikingo2);
        vikingo2.meditar();

        // Assert
        assertEquals(vikingo2.getEstado(), NORMAL);
        assertEquals(vikingo2.getVida(), 70);
    }

    @Test
    public void cuandoEstaCalmadoYMedita_SigueEnCalmado() {
        // Act
        vikingo1.meditar();
        vikingo1.meditar();

        // Assert
        assertEquals(vikingo1.getEstado(), CALMADO);
    }

    @Test
    public void cuandoEstaCalmadoYHaceDanio_PasaANormal() {
        // Act
        vikingo1.meditar();
        vikingo1.hacerDanio(vikingo2);

        // Assert
        assertEquals(vikingo1.getEstado(), NORMAL);
        assertEquals(vikingo2.getVida(), 90);
    }

    @Test
    public void cuandoEstaEnNormalYHaceDanio_NoCambiaDeEstado() {
        // Act
        vikingo1.hacerDanio(vikingo2);

        // Assert
        assertEquals(vikingo1.getEstado(), NORMAL);
        assertEquals(vikingo2.getVida(), 90);
    }

    @Test
    public void cuandoEstaEnColericoYHaceDanio_NoCambiaDeEstado() {
        // Act
        vikingo2.hacerDanio(vikingo1);
        vikingo1.hacerDanio(vikingo2);

        // Assert
        assertEquals(vikingo1.getEstado(), COLERICO);
        assertEquals(vikingo2.getEstado(), COLERICO);
        assertEquals(vikingo1.getVida(), 90);
        assertEquals(vikingo2.getVida(), 80);
    }

    @Test
    public void cuandoEstaEnBerserkerYHaceDanio_NoCambiaDeEstado() {
        // Act
        vikingo2.hacerDanio(vikingo1);
        vikingo2.hacerDanio(vikingo1);
        vikingo1.hacerDanio(vikingo2);

        // Assert
        assertEquals(vikingo1.getEstado(), BERSERKER);
        assertEquals(vikingo2.getEstado(), COLERICO);
        assertEquals(vikingo1.getVida(), 70);
        assertEquals(vikingo2.getVida(), 70);
    }

}