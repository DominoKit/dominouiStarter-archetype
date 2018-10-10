#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import com.google.gwt.core.client.EntryPoint;
import elemental2.core.Global;
import elemental2.dom.Request;
import elemental2.dom.RequestInit;
import elemental2.dom.Response;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.dominokit.domino.ui.Typography.Paragraph;
import org.dominokit.domino.ui.Typography.Strong;
import org.dominokit.domino.ui.alerts.Alert;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.layout.Layout;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.ui.tree.Tree;
import org.dominokit.domino.ui.tree.TreeItem;

import static elemental2.dom.DomGlobal.fetch;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class App implements EntryPoint {

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        Layout layout = Layout.create("Domino-ui starter")
                .show(ColorScheme.BLUE);

        layout.getLeftPanel()
                .appendChild(Tree.create("Menu")
                        .appendChild(TreeItem.create("Menu 1", Icons.ALL.widgets())
                                .addClickListener(evt -> layout.setContent(Card.create("Menu 1")
                                        .appendChild(Paragraph.create("Welcome to domino-ui , you are viewing menu 1 content"))
                                ))
                        )
                        .appendChild(TreeItem.create("Menu 2", Icons.ALL.widgets())
                                .addClickListener(evt -> layout.setContent(Card.create("Menu 2")
                                        .appendChild(Paragraph.create("Welcome to domino-ui , you are viewing menu 2 content"))
                                ))
                        ));

        RequestInit requestInit = RequestInit.create();
        requestInit.setMethod("get");
        fetch(new Request("http://localhost:8080/app/greet?id=1&name=dominoui", requestInit))
                .then(Response::json)
                .then(response -> {
                    Person person = new Person();

                    JsPropertyMap<String> parse = Js.cast(Global.JSON.parse(Global.JSON.stringify(response)));
                    person.setId(Integer.valueOf(parse.get("id")));
                    person.setName(parse.get("name"));

                    layout.setContent(Alert.success()
                            .dismissible()
                            .appendChild(Strong.of("Welcome : "+person.getId() +":"+person.getName())));
                    return null;
                });


    }
}
