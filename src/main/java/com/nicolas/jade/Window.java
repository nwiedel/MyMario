package com.nicolas.jade;

import org.lwjgl.Version;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.NULL;

public class Window {

    private int width;
    private int height;
    private String title;

    private long glfwWindow;

    private static Window window = null;

    private Window(){
        this.width = 1920;
        this.height = 1080;
        this.title = "MyMario";
    }

    public static Window get(){
        if(Window.window == null){
            Window.window = new Window();
        }

        return Window.window;
    }

    public void run(){
        System.out.println("Hello LWJGL " + Version.getVersion() + "!");
        init();
        loop();
    }

    public void init(){
        // Setup an error callback. The default implementation
        // will print the error message in System.err
        GLFWErrorCallback.createPrint(System.err).set();

        // Initialize GLFW.  Most GLFW functions will not work before doing this
        if(!glfwInit()){
            throw new IllegalStateException("Unable to initialize GLFW!");
        }

        // configure GLFW
        glfwDefaultWindowHints(); // optional, the current window hints are already the default
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); // the window will stay hidden after creation
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE); // the window will be resizable
        glfwWindowHint(GLFW_MAXIMIZED, GLFW_TRUE); // window is in the maximized position

        // Create the window.
        glfwWindow = glfwCreateWindow(this.width, this.height,this.title,NULL, NULL);
        if(glfwWindow == NULL){
            throw new IllegalStateException("Failed to create the GLFW window!");
        }

        // Make the OpenGL context current.
        glfwMakeContextCurrent(glfwWindow);

        // Enable v-sync
        glfwSwapInterval(0);

        // Make the window visible
        glfwShowWindow(glfwWindow);

        // This line is critical for LWJGL's interoperation with GLFW's
        // OpenGL context, or any context that is managed externally.
        // LWJGL detects the context that is current in the current thread,
        // creates the GLCapabilities instance and makes the OpenGL
        // bindings available for use.
        GL.createCapabilities();
    }

    public void loop(){

        // Run the rendering loop until the user has attempted to close
        // the window or has pressed the ESCAPE key.
        while(!glfwWindowShouldClose(glfwWindow)){

            // Poll for window events. The key callback above will only be
            // invoked during this call.
            glfwPollEvents();

            glClearColor(0.388f,0.584f, 0.933f, 0.0f);
            glClear(GL_COLOR_BUFFER_BIT);

            glfwSwapBuffers(glfwWindow); // swap the color buffer
        }
    }
}
