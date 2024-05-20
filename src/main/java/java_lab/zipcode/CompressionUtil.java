//package java_lab.zipcode;
//
//import java.io.BufferedOutputStream;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.nio.charset.Charset;
//import java.util.Stack;
//
//public class CompressionUtil {
//    private final static int BUF_SIZE = 1024 * 8;
//
//    public void unzip(File zippedFile, File destDir) throws IOException {
//        if (destDir.exists() == false) {
//            destDir.mkdir();
//        }
//        unzip(new FileInputStream(zippedFile), destDir, Charset.defaultCharset().name());
//    }
//
//    /**
//     * 압축파일을 해제
//     *
//     * @param zippedFile  : 압축풀 대상파일
//     * @param destDir     : 압축이 해제될 디렉터리경로
//     * @param charsetName : 캐릭터셋 지정
//     * @throws IOException
//     */
//    public void unzip(File zippedFile, File destDir, String charsetName) throws IOException {
//        if (destDir.exists() == false) {
//            destDir.mkdir();
//        }
//        unzip(new FileInputStream(zippedFile), destDir, charsetName);
//    }
//
//    public void unzip(InputStream is, File destDir, String charsetName) throws IOException {
//        ZipArchiveInputStream zis = new ZipArchiveInputStream(is, charsetName, false);
//        ZipArchiveEntry entry = null;
//        int nWritten = 0;
//        byte[] buf = new byte[BUF_SIZE];
//        try {
//            while ((entry = zis.getNextZipEntry()) != null) {
//                File target = new File(destDir, entry.getName());
//                //zip 파일내 해당 엔트리가 디렉토리면
//                if (entry.isDirectory()) {
//                    target.mkdirs(); /* does it always work? */
//                } else {
//                    File f = new File(target.getParent());
//                    if (f.exists() == false) {
//                        f.mkdir();
//                    }
//                    target.createNewFile();
//                    BufferedOutputStream bos = null;
//                    try {
//                        bos = new BufferedOutputStream(new FileOutputStream(target));
//                        while ((nWritten = zis.read(buf)) >= 0) {
//                            bos.write(buf, 0, nWritten);
//                        }
//                    } finally {
//                        if (bos != null) {
//                            bos.close();
//                        }
//                    }
//                }
//            }
//        } finally {
//            if (zis != null) {
//                zis.close();
//            }
//        }
//    }
//
//    /**
//     * 디렉터리를 압축
//     *
//     * @param src        : 압축할 디렉터리 경로
//     * @param includeSrc : 압축시 루트디렉터리 안에 압축할지 여부
//     * @throws IOException
//     */
//    public void zip(File src, boolean includeSrc) throws IOException {
//        zip(src, Charset.defaultCharset().name(), includeSrc);
//    }
//
//    /**
//     * 디렉터리를 압축
//     *
//     * @param src         : 압축할 디렉터리 경로
//     * @param includeSrc  : 압축시 루트디렉터리 안에 압축할지 여부
//     * @param charsetName : 캐릭터셋 지정
//     * @throws IOException
//     */
//    public void zip(File src, boolean includeSrc, String charsetName) throws IOException {
//        zip(src, charsetName, includeSrc);
//    }
//
//    public void zip(File src, String charSetName, boolean includeSrc) throws IOException {
//        zip(src, src.getParentFile(), charSetName, includeSrc);
//    }
//
//    public void zip(File src, File destDir, String charSetName, boolean includeSrc) throws IOException {
//        String fileName = src.getName();
//        if (src.isDirectory() == false) {
//            final int pos = fileName.lastIndexOf(".");
//            if (pos > 0) {
//                fileName = fileName.substring(0, pos);
//            }
//        }
//        fileName += ".zip";
//        File zippedFile = new File(destDir, fileName);
//        if (zippedFile.exists() != false) {
//            zippedFile.createNewFile();
//        }
//        zip(src, new FileOutputStream(zippedFile), charSetName, includeSrc);
//    }
//
//    public void zip(File src, OutputStream os, String charsetName, boolean includeSrc) throws IOException {
//        ZipArchiveOutputStream zos = new ZipArchiveOutputStream(os);
//        zos.setEncoding(charsetName);
//        FileInputStream fis = null;
//        int length;
//        ZipArchiveEntry ze = null;
//        byte[] buf = new byte[BUF_SIZE];
//        String name = null;
//        Stack<File> stack = new Stack<File>();
//        File root = null;
//        if (src.isDirectory()) {
//            if (includeSrc) {
//                stack.push(src);
//                root = src.getParentFile();
//            } else {
//                File[] fs = src.listFiles();
//                for (int i = 0; i < fs.length; i++) {
//                    stack.push(fs[i]);
//                }
//                root = src;
//            }
//        } else {
//            stack.push(src);
//            root = src.getParentFile();
//        }
//        try {
//            while (stack.isEmpty() == false) {
//                File f = stack.pop();
//                name = toPath(root, f);
//                if (f.isDirectory()) {
//                    File[] fs = f.listFiles();
//                    for (int i = 0; i < fs.length; i++) {
//                        if (fs[i].isDirectory()) {
//                            stack.push(fs[i]);
//                        } else {
//                            stack.add(0, fs[i]);
//                        }
//                    }
//                } else {
//                    ze = new ZipArchiveEntry(name);
//                    zos.putArchiveEntry(ze);
//                    fis = new FileInputStream(f);
//                    try {
//                        while ((length = fis.read(buf, 0, buf.length)) >= 0) {
//                            zos.write(buf, 0, length);
//                        }
//                    } finally {
//                        if (fis != null) {
//                            fis.close();
//                        }
//                        zos.closeArchiveEntry();
//                    }
//                }
//            }
//        } finally {
//            if (zos != null) {
//                zos.close();
//            }
//        }
//    }
//
//    private String toPath(File root, File dir) {
//        String path = dir.getAbsolutePath();
//        path = path.substring(root.getAbsolutePath().length()).replace(File.separatorChar, '/');
//        if (path.startsWith("/")) {
//            path = path.substring(1);
//        }
//        if (dir.isDirectory() && path.endsWith("/") == false) {
//            path += "/";
//        }
//        return path;
//    }
//}
