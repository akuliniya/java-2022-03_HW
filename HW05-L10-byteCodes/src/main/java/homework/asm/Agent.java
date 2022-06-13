//package homework.asm;
//
//import org.objectweb.asm.*;
//import org.objectweb.asm.commons.AdviceAdapter;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.OutputStream;
//import java.lang.instrument.ClassFileTransformer;
//import java.lang.instrument.Instrumentation;
//import java.security.ProtectionDomain;
//import java.util.Set;
//
//public class Agent {
//    public static void premain(String agentArgs, Instrumentation inst) {
//        System.out.println("premain");
//        BeanFactory beanFactory = new BeanFactory();
//        String basePackage = new File("").getAbsolutePath();
//        beanFactory.instantiate("homework.proxy.simple");
//        var classesForLogging = beanFactory.getBeans();
//
//        inst.addTransformer(new ClassFileTransformer() {
//            @Override
//            public byte[] transform(ClassLoader loader, String className,
//                                    Class<?> classBeingRedefined,
//                                    ProtectionDomain protectionDomain,
//                                    byte[] classfileBuffer) {
//                for (var clazz : classesForLogging.keySet()) {
//                    if (className.equals(clazz)) {
//                        return changeMethod(classfileBuffer, classesForLogging.get(clazz));
//                    }
//                }
//                return classfileBuffer;
//            }
//        });
//    }
//
//    private static byte[] changeMethod(byte[] originalClass, Set<String> methods) {
//        var cr = new ClassReader(originalClass);
//        var cw = new ClassWriter(cr, ClassWriter.COMPUTE_MAXS);
//        ClassVisitor cv = new ClassVisitor(Opcodes.ASM7, cw, methods) {
//            @Override
//            public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
//                var methodVisitor = super.visitMethod(access, name, descriptor, signature, exceptions);
//
//                    if (name.equals(method)) {
//                        return new ChangeMethodVisitor(methodVisitor, access, name, descriptor);
//                    } else {
//                        return methodVisitor;
//                    }
//
//            }
//        };
//        cr.accept(cv, Opcodes.ASM7);
//
//        byte[] finalClass = cw.toByteArray();
//
//        try (OutputStream fos = new FileOutputStream("changer.class")) {
//            fos.write(finalClass);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return finalClass;
//    }
//
//    private static class ChangeMethodVisitor extends AdviceAdapter {
//        ChangeMethodVisitor(MethodVisitor methodVisitor, int access, String name, String descriptor) {
//            super(Opcodes.ASM7, methodVisitor, access, name, descriptor);
//        }
//
//        @Override
//        public void visitInsn(final int opcode) {
//            if (IADD == opcode) {
//                System.out.println("replace IADD to ISUB");
//                super.visitInsn(ISUB);
//            } else {
//                super.visitInsn(opcode);
//            }
//        }
//    }
//}
