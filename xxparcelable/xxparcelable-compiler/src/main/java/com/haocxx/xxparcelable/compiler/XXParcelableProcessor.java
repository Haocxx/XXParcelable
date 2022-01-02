package com.haocxx.xxparcelable.compiler;

import java.io.Writer;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;

import com.haocxx.xxparcelable.core.annotation.AutoParcelable;

/**
 * Created by Haocxx
 * on 2022/1/2
 */
public class XXParcelableProcessor extends AbstractProcessor {
  private static final String PACKAGE_NAME = "XXParcelablePackageName";
  private boolean mHasProcessed;
  private String mPackageName;
  private Filer mFiler;
  private Writer mWriter;

  @Override
  public synchronized void init(ProcessingEnvironment processingEnvironment) {
    super.init(processingEnvironment);
    String fullName = processingEnv.getOptions().get(PACKAGE_NAME);
    if (fullName == null) {
      mHasProcessed = true;
      return;
    }
    mPackageName = fullName;
    mFiler = processingEnvironment.getFiler();
  }

  @Override
  public Set<String> getSupportedAnnotationTypes() {
    HashSet<String> supportTypes = new LinkedHashSet<>();
    supportTypes.add(AutoParcelable.class.getCanonicalName());
    return supportTypes;
  }

  @Override
  public SourceVersion getSupportedSourceVersion() {
    return SourceVersion.latestSupported();
  }

  @Override
  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
    return false;
  }
}
