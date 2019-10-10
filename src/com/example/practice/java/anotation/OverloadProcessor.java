package com.example.practice.java.anotation;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class OverloadProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Messager messager = processingEnv.getMessager();
        for (Element annotatedElement : roundEnv.getElementsAnnotatedWith(Overload.class)) {
            messager.printMessage(Diagnostic.Kind.MANDATORY_WARNING, "Cant use this anotation, sorry");
            /* Can also use other message types such as error, which makes the compilation fail */
        }
        return true;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return new HashSet<>(Arrays.asList(Overload.class.getName()));
    }
}
