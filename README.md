# nattadasu's Personal Groovy Scripts for FileBot

Ready-to-use collection of Groovy scripts for FileBot to rename media files

## Disclaimer

For UNIX-Like user: This repo assumes your distro as Fedora Linux as the drive
mountpoint was hard-coded (`/run/media/<username>/<drive_name>`) rather usual
`/mnt/<drive_name>` that still being used by some distros. You can change
default behavior on `filepath_posix.groovy`

## Usage

0. Clone this repository to your home directory (Windows: `%USERPROFILE%`, POSIX: `~`)
1. Modify the scripts, if needed
2. In your FileBot format configurator, import it with `@` notation.

### POSIX, TV

```groovy
@FileBot/_posix_tv.groovy
```

### POSIX, Movies

```groovy
@FileBot/_posix_movie.groovy
```

### Windows, TV

```groovy
@FileBot/_windows_tv.groovy
```

### Windows, Movies

```groovy
@FileBot/_windows_movie.groovy
```

## Examples

### TV, First Example

Before:

```txt
Sakuna.Of.Rice.and.Ruin.S01E01.1080p.YT.WEB-DL.JPN.AAC2.0.H.264.MSubs-TH.mkv
```

After:

```txt
/run/media/username/Videos/Videos/Anime/Sakuna Of Rice and Ruin/Season 1/[TH] Sakuna Of Rice and Ruin - S01E01 - Episode 1 [WEB-DL 1920x1080 AVC 8Bit, AAC 2.0, Multi-Subs (ENG ZHO IND MSA THA VIE)][38F1CEF4].mkv
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
