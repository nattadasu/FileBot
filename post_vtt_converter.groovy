{ source, target, metadata ->
    // Only process video files
    if (!f.video) {
        return
    }

    // Detect Windows platform
    def is_windows = System.getProperty("os.name").toLowerCase().contains("windows")

    // Path to convert_vtt_to_ass.py script
    def convert_script = is_windows ? "C:\\Users\\nattadasu\\Scripts\\convert_vtt_to_ass.py" : "/home/nattadasu/Scripts/convert_vtt_to_ass.py"
    def convert_py_file = new File(convert_script)
    if (!convert_py_file.exists()) {
        println("[VTT Converter] Error: convert_vtt_to_ass.py not found at ${convert_script}")
        return
    }

    // Find VTT subtitle files derived from this video file
    target.dir.listFiles().findAll{ it.subtitle && it.ext == 'vtt' && it.isDerived(target) }.each { vtt_file ->
        try {
            println("[VTT Converter] Converting: ${vtt_file.name}")

            // Call convert_vtt_to_ass.py using the venv python binary
            def python_bin = is_windows ? "C:\\Users\\nattadasu\\Scripts\\.venv\\Scripts\\python.exe" : "/home/nattadasu/Scripts/.venv/bin/python3"
            system python_bin, convert_script, vtt_file.toString()

            // Delete original VTT file
            vtt_file.delete()

            println("[VTT Converter] ✓ Converted ${vtt_file.name} to ASS")

        } catch (Exception e) {
            println("[VTT Converter] Error processing ${vtt_file.name}: ${e.message}")
        }
    }
}
