<!-- markdownlint-disable MD033 -->
# nattadasu's Personal Groovy Scripts for FileBot

Ready-to-use collection of Groovy scripts for FileBot to rename media files.

File format were optimized to be used alongside Anitomy-based parser (Taiga)
for Anime, while keeping it sane for other media library parsers to understand
as well.

## Post-Processing Scripts

### NFO generator for Episodes

This script will generate NFO file for each episode, containing metadata that
can be read by Kodi, Jellyfin, Emby, etc.

#### Requirements

* `curl` available on your path
* The Movie DB (TMDB) as source for metadata
* TMDB API key, obtain from [Settings](https://www.themoviedb.org/settings/api).

#### Configuration

Save following format to `~/.filebotsecrets.json`. DO NOT SHARE THIS FILE!

```json
{
  "tmdb_api": "your_tmdb_api_key",
  "language": "en-US",
  "person_info_dir": "/path/to/person_info/"
}
```

#### Usage for NFO Generator

> [!IMPORTANT]
>
> See [\[DOCS\] Custom Post-Processing Scripts](https://www.filebot.net/forums/viewtopic.php?t=13769)
> for official guide on how to use this script.

##### GUI

1. Open FileBot
2. Right click on "Rename" button
3. Click "Post Process" > a small button on right bottom of the dialog > "New Script"
4. Copy-past content from `post_xmbcnfo.groovy` to the script editor
5. Save the script

##### CLI

```sh
filebot --apply /path/to/post_xmbcnfo.groovy
```

Apply argument should be also executable on AMC script.

## Custom Presets

### Calibre-optimized OPF Metadata Preset

This preset is optimized for Calibre OPF metadata format, really useful if you
want to mirror your books to other devices or media server (e.g. Jellyfin) by
duplicating or hardlink to new location.

The preset script assumes that your book metadata is complete and properly
formatted, and will use it to rename the file.

#### Calibre Binding Reference

> [!NOTE]
>
> If the binding have stated FileBot-like variable, it means that you can use
> FileBot variable as alias for the binding.

| Variable       | Aliases                                    | Description                                            | FileBot Similar Variable |
| -------------- | ------------------------------------------ | ------------------------------------------------------ | ------------------------ |
| `aaz`          |                                            | Sort collection letter, `author`                       |                          |
| `age`          |                                            | Age of the book by day, based on `timestamp` - `today` |                          |
| `amazon`       | `amazon_jp`, `asin`, `amazonid`            | Amazon ASIN                                            |                          |
| `author`       |                                            | First author                                           |                          |
| `authors`      |                                            | Authors                                                |                          |
| `az`           |                                            | Sort collection letter, `sort_title`                   |                          |
| `barnesnoble`  | `barnesnobleid`                            | Barnes & Noble ID                                      |                          |
| `calibre`      | `calibreid`                                | Calibre integer ID                                     | `id`                     |
| `calibreuuid`  | `uuid`                                     | Calibre UUID                                           |                          |
| `contributor`  |                                            | Contributors                                           |                          |
| `date`         |                                            | Book release date                                      | `d`                      |
| `decade`       |                                            | Book release decade                                    |                          |
| `description`  |                                            | Description                                            |                          |
| `gaz`          |                                            | Sort collection letter, `genre`                        |                          |
| `genre`        |                                            | Genre                                                  |                          |
| `genres`       |                                            | List of genres                                         |                          |
| `goodreads`    | `goodreadsid`                              | Goodreads ID                                           |                          |
| `google`       | `googleid`, `googlebooks`, `googlebooksid` | Google Books ID                                        |                          |
| `isbn`         |                                            | ISBN                                                   |                          |
| `jellyfin`     |                                            | Jellyfin-compatible collection name                    |                          |
| `language`     |                                            | Language                                               | `lang`                   |
| `laz`          |                                            | Sort collection letter, `language`                     |                          |
| `ny`           |                                            | Series name with year of release                       |                          |
| `paz`          |                                            | Sort collection letter, `publisher`                    |                          |
| `publisher`    |                                            | Publisher                                              |                          |
| `rating`       |                                            | Rating                                                 |                          |
| `rights`       |                                            | Rights                                                 |                          |
| `saz`          |                                            | Sort collection letter, `series`                       |                          |
| `series_index` | `si`, `volume`, `v`                        | Series index                                           | `s`                      |
| `series`       | `sn`                                       | Series                                                 | `n`                      |
| `sort_authors` |                                            | Sort authors                                           |                          |
| `sort_title`   | `st`                                       | Sort title                                             |                          |
| `ssaz`         |                                            | Sort collection letter, `sort_series`                  |                          |
| `tags`         |                                            | Tags                                                   |                          |
| `taz`          |                                            | Sort collection letter, `title`                        |                          |
| `timestamp`    | `ts`                                       | Added date                                             |                          |
| `title`        |                                            | Title                                                  | `t`                      |
| `year`         |                                            | Book release year                                      | `y`                      |

##### FileBot Build-in Variables

Below is the table of which binding that still works well natively and has been
tested.

| Variable    | Description            |
| ----------- | ---------------------- |
| `today`     | Current date           |
| `fn`        | Current file name      |
| `ext`       | Current file extention |
| `crc32`     | CRC32 checksum         |
| `ct`        | Created date           |
| `f`         | File object            |
| `folder`    | Folder object          |
| `drive`     | Drive object           |
| `bytes`     | File size in bytes     |
| `megabytes` | File size in megabytes |
| `gigabytes` | File size in gigabytes |

## File Formatting

Below is the guide if you want to use File Formatting feature on this repo.

### Disclaimer

For UNIX-Like user: This repo assumes your distro as Fedora Linux as the drive
mountpoint was hard-coded (`/run/media/<username>/<drive_name>`) rather usual
`/mnt/<drive_name>` that still being used by some distros. You can change
default behavior on `modules/filepath_posix.groovy`

### Editing

If you want to edit the scripts, keep in mind that the scripts are written in
favor of my personal preference, and might be not suitable for you.

However, the most important files were:

* `filepath_posix.groovy` and `filepath_windows.groovy` on modules folder are
  the scripts that handles <u>(default) drive logic</u>. By default, it tries to
  find the drive that have most free space, and if it's not found, it will use
  the default drive. You can override by changing `override` variable on the
  script.
* `common_` are shared scripts that does not have OS-specific behavior (drive
  logic, etc.), and only contains common logic to handle <u>file name</u>.

Additionally, there are some quality-of-life scripts that you can edit to enhance
your experience:

* `forceshowid_tv.groovy` to force write ID from TMDB to avoid incorrect ID
  detection on Jellyfin/Emby, etc when there are multiple shows with the same
  name (e.g. different years, anime vs live-action, etc.)
* `medianame.groovy` to handle media name, shortening it, etc. Useful when a
  fricking adapted-from-Light-Novel anime title is way too long, or making sure
  it has consistent naming (e.g. case sensitivity, stylization, etc.)
* `releasegroup.groovy` to handle additional release group when FileBot does not
  include it on its group index, or fixing it when it's incorrect.
* `releasesource.groovy` to handle additional release source when FileBot does
  not include it on its source index, or fixing it when it's incorrect.

You can refer to `compiled/` directory to check logics that FileBot will use.

### Usage for File Formatting

0. Clone this repository to your home directory (Windows: `%USERPROFILE%`,
   POSIX: `~`)
1. Modify the scripts, if needed
2. In your FileBot format configurator, import it with `@` notation.

> [!IMPORTANT]
>
> If you want to use the script on FileBot AMC and don't want to make your log
> file to be cluttered with script content, you can use `compiled/` directory
> since it already being minified to the most extent (<4K chars on compiled vs
> \>7K on `_*.groovy`).
>
> To use, replace `@FileBot/_posix_tv.groovy` to `@FileBot/compiled/posix_tv.groovy`,
> and so on.

#### POSIX, TV

THIS SCRIPT MUST BE USED WITH TMDB AS DATA SOURCE

```groovy
@FileBot/_posix_tv.groovy
```

#### POSIX, Movies

THIS SCRIPT MUST BE USED WITH TMDB AS DATA SOURCE

```groovy
@FileBot/_posix_movie.groovy
```

#### POSIX, Music (to Share)

```groovy
@FileBot/_posix_music_shared.groovy
```

#### Windows, TV

THIS SCRIPT MUST BE USED WITH TMDB AS DATA SOURCE

```groovy
@FileBot/_windows_tv.groovy
```

#### Windows, Movies

THIS SCRIPT MUST BE USED WITH TMDB AS DATA SOURCE

```groovy
@FileBot/_windows_movie.groovy
```

#### Windows, Music (to Share)

```groovy
@FileBot/_windows_music_shared.groovy
```

### Examples

#### TV, First Example

Before:

```txt
Sakuna.Of.Rice.and.Ruin.S01E01.1080p.YT.WEB-DL.JPN.AAC2.0.H.264.MSubs-TH.mkv
```

After:

```txt
/run/media/username/Videos/Videos/Anime/Sakuna Of Rice and Ruin/Season 1/[TH] Sakuna Of Rice and Ruin - S01E01 - Episode 1 [YT.WEB-DL 1920x1080 AVC 8Bit, AAC 2.0, MSub (ENG ZHO IND MSA THA ...)][38F1CEF4].mkv
```

#### TV, Second Example

Before:

```txt
[Ehe] Kuroshitsuji BD - 01.mkv
```

After:

```txt
/run/media/username/Videos/Videos/Anime/Black Butler/Season 1 - Black Butler/[Ehe] Black Butler - S01E01 - His Butler, Able [BD 1280x720 AVC 10Bit, AAC 2.0][9FA9EEFC].mkv
```

#### Movie

Before:

```txt
Suicide.Squad.2016.1080p.BluRay.DDP5.1.x265.10bit-Ginga.mkv
```

After:

```txt
/run/media/username/Videos/Videos/Movies/Suicide Squad (2016) [tmdbid-297761]/[Ginga] Suicide Squad [BluRay 1920x1080 HEVC 10Bit, EAC3 DD 5.1][EF045D2F].mkv
```

#### Music

Assuming it has been properly tagged with MusicBrainz Picard or any advanced
tag editor previously:

```txt
1_01_Noname.flac
```

After:

```txt
/home/username/Torrent Uploads/FLAC/2012/[2012.12.21] ノナメ - M-chan [FLAC 24-48.0 KHz][ABCD-12345]/1-01 ノナメ.flac
```
