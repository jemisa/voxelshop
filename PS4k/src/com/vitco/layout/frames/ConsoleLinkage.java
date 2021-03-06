package com.vitco.layout.frames;

import com.jidesoft.docking.DockableFrame;
import com.vitco.layout.content.console.ConsoleViewInterface;
import com.vitco.manager.action.types.StateActionPrototype;
import com.vitco.util.misc.SaveResourceLoader;

import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * construct the console frame
 */
public class ConsoleLinkage extends FrameLinkagePrototype {

    // var & setter
    private ConsoleViewInterface consoleView;
    public final void setConsoleView(ConsoleViewInterface consoleView) {
        this.consoleView = consoleView;
    }

    @Override
    public DockableFrame buildFrame(String key, Frame mainFrame) {
        // construct frame
        frame = new DockableFrame(key,
                new SaveResourceLoader("resource/img/icons/frames/console.png").asIconImage()
        );
        updateTitle(); // update the title

        frame.add(consoleView.buildConsole(this));

        // register action to hide/show this frame and get visible state
        actionManager.registerAction("console_state-action_show", new StateActionPrototype() {
            @Override
            public boolean getStatus() {
                return frame.isVisible();
            }

            @Override
            public void action(ActionEvent e) {
                toggleVisible();
            }
        });

        return frame;
    }
}
