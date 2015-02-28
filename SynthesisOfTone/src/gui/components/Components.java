package gui.components;

import java.awt.Container;

public class Components {

    private final Container container;

    private Title title;
    private GraphPanel graphPanel;
    private AmplPanel amplPanel;
    private PhasePanel phasePanel;
    private FrekvPanel frekvPanel;

    private SettingButtonsPanel settingButtonsPanel;
    private ControllButtonsPanel controllPanel;

    public Components(Container container) {
        this.container = container;
        container.setLayout(null);
    }

    public void init() {
        initTitle();

        graphPanel = new GraphPanel();
        amplPanel = new AmplPanel();
        phasePanel = new PhasePanel();
        frekvPanel = new FrekvPanel();

        settingButtonsPanel = new SettingButtonsPanel();
        controllPanel = new ControllButtonsPanel();
    }

    private void initTitle() {
        title = new Title();
        title.createComponentsForPanel();
        container.add(title.getPanel());
    }

}
