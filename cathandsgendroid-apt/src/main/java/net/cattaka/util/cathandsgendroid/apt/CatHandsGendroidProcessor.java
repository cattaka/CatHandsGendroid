
package net.cattaka.util.cathandsgendroid.apt;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

import net.cattaka.util.cathandsgendroid.annotation.DataModel;

/**
 * Annotation processing logic.
 * 
 * @author cattaka
 */
@SupportedSourceVersion(SourceVersion.RELEASE_6)
@SupportedAnnotationTypes("net.cattaka.util.cathandsgendroid.annotation.*")
public class CatHandsGendroidProcessor extends AbstractProcessor {
    @Override
    public synchronized void init(ProcessingEnvironment env) {
        super.init(env);
    }

    @Override
    public boolean process(Set<? extends TypeElement> elements, RoundEnvironment roundEnv) {
        DataModelProcessor processor = new DataModelProcessor(processingEnv);
        for (Element element : roundEnv.getElementsAnnotatedWith(DataModel.class)) {
            processor.process((TypeElement)element, roundEnv);
        }
        return false;
    }
}
