package co.com.practica.runners;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/resources/features/prueba.feature",
    glue = {"co.com.practica.definitions"},
    snippets = SnippetType.CAMELCASE)
public class pruebaRunner {}
