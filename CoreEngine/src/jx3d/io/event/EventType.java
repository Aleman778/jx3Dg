package jx3d.io.event;

/**
 * All types of event.
 */
public enum EventType {
    None,
    WindowClose, WindowResize, WindowFocus, WindowLostFocus, WindowMoved,
    AppSetup, AppUpdate, AppDraw,
    KeyDown, KeyUp,
    MousePressed, MouseReleased, MouseMoved, MouseDragged, MouseScrolled, MouseEntered, MouseExited
}
