<!-- markdownlint-disable MD033 -->
# nattadasu's Personal Groovy Scripts for FileBot

Ready-to-use collection of Groovy scripts for FileBot to rename media files.

File format were optimized to be used alongside Anitomy-based parser (Taiga)
for Anime, while keeping it sane for other media library parsers to understand
as well.

## Disclaimer

For UNIX-Like user: This repo assumes your distro as Fedora Linux as the drive
mountpoint was hard-coded (`/run/media/<username>/<drive_name>`) rather usual
`/mnt/<drive_name>` that still being used by some distros. You can change
default behavior on `filepath_posix.groovy`

## Editing

If you want to edit the scripts, keep in mind that the scripts are written in
favor of my personal preference, and might be not suitable for you.

However, the most important files were:

* `filepath_posix.groovy` and `filepath_windows.groovy` are the scripts that
  handles <u>(default) drive logic</u>. By default, it tries to find the drive
  that have most free space, and if it's not found, it will use the default
  drive. You can override by changing `override` variable on the script.
* `common_` are shared scripts that does not have OS-specific behavior (drive
  logic, etc.), and only contains common logic to handle <u>file name</u>.

You can refer to `compiled/` directory to check logics that FileBot will use.

## Usage

0. Clone this repository to your home directory (Windows: `%USERPROFILE%`,
   POSIX: `~`)
1. Modify the scripts, if needed
2. In your FileBot format configurator, import it with `@` notation.

> [!WARNING]
>
> Due to weird bug on CLI, rather using `_*.groovy`, replace it to `compiled/*.groovy`,
> for example: `_posix_tv.groovy` to `compiled/posix_tv.groovy`, and so on.

### POSIX, TV

THIS SCRIPT MUST BE USED WITH TMDB AS DATA SOURCE

```groovy
@FileBot/_posix_tv.groovy
```

### POSIX, Movies

THIS SCRIPT MUST BE USED WITH TMDB AS DATA SOURCE

```groovy
@FileBot/_posix_movie.groovy
```

### POSIX, Music (to Share)

```groovy
@FileBot/_posix_music_shared.groovy
```

### Windows, TV

THIS SCRIPT MUST BE USED WITH TMDB AS DATA SOURCE

```groovy
@FileBot/_windows_tv.groovy
```

### Windows, Movies

THIS SCRIPT MUST BE USED WITH TMDB AS DATA SOURCE

```groovy
@FileBot/_windows_movie.groovy
```

### Windows, Music (to Share)

```groovy
@FileBot/_windows_music_shared.groovy
```

## Examples

### TV, First Example

Before:

```txt
Sakuna.Of.Rice.and.Ruin.S01E01.1080p.YT.WEB-DL.JPN.AAC2.0.H.264.MSubs-TH.mkv
```

After:

```txt
/run/media/username/Videos/Videos/Anime/Sakuna Of Rice and Ruin/Season 1/[TH] Sakuna Of Rice and Ruin - S01E01 - Episode 1 [YT.WEB-DL 1920x1080 AVC 8Bit, AAC 2.0, Multi-Subs (ENG ZHO IND MSA THA ...)][38F1CEF4].mkv
```

### TV, Second Example

Before:

```txt
[Ehe] Kuroshitsuji BD - 01.mkv
```

After:

```txt
/run/media/username/Videos/Videos/Anime/Black Butler/Season 1 - Black Butler/[Ehe] Black Butler - S01E01 - His Butler, Able [BD 1280x720 AVC 10Bit, AAC 2.0][9FA9EEFC].mkv
```

### Movie

Before:

```txt
Suicide.Squad.2016.1080p.BluRay.DDP5.1.x265.10bit-Ginga.mkv
```

After:

```txt
/run/media/username/Videos/Videos/Movies/Suicide Squad (2016) [tmdbid-297761]/[Ginga] Suicide Squad [BluRay 1920x1080 HEVC 10Bit, EAC3 DD 5.1][EF045D2F].mkv
```

### Music

Assuming it has been properly tagged with MusicBrainz Picard or any advanced
tag editor previously:

```txt
1_01_Noname.flac
```

After:

```txt
/home/username/Torrent Uploads/FLAC/2012/[2012.12.21] ノナメ - M-chan [FLAC 24-48.0 KHz][ABCD-12345]/1-01 ノナメ.flac
```
