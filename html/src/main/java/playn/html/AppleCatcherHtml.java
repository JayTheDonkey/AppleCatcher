package playn.html;

import com.google.gwt.core.client.EntryPoint;
import playn.html.HtmlPlatform;
import playn.core.AppleCatcher;

public class AppleCatcherHtml implements EntryPoint {

  @Override public void onModuleLoad () {
    HtmlPlatform.Config config = new HtmlPlatform.Config();
    // use config to customize the HTML platform, if needed
    HtmlPlatform plat = new HtmlPlatform(config);
    plat.assets().setPathPrefix("applecatcher/");
    new AppleCatcher(plat);
    plat.start();
  }
}