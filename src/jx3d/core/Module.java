package jx3d.core;

import jx3d.graphics.Graphics;

/**
 * The module class is an abstract component of an application. A module contains handles
 * to the most important properties of the module and its surrounding modules.
 * @since 1.0
 * @author Aleman778
 */
public abstract class Module {
	
	/**
	 * The handle to the display that this module lives in.
	 */
	public Display display;
	
	/**
	 * The handle to the rendering engine that is being used by this display.
	 * @see #display
	 */
	public Graphics graphics;
}
