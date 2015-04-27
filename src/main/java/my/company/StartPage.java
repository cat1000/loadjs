package my.company;


import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.AjaxCallListener;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.OnDomReadyHeaderItem;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.Radio;
import org.apache.wicket.markup.html.form.RadioGroup;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by christoph on 18.04.15.
 */
public class StartPage extends WebPage {

    /**
     * Constructor
     */
    public StartPage() {

        Link helpLink = new AjaxFallbackLink("help") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                target.add(getPage().add(new Behavior() {
                    @Override
                    public void renderHead(Component component, IHeaderResponse response) {
                        super.renderHead(component, response);
                        response.render(OnDomReadyHeaderItem.forScript("alert('test')"));
                    }

                    @Override
                    public boolean isTemporary(Component component) {
                        return true;
                    }
                }));

            }

        };

        add(helpLink);


    }


}
