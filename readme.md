Tiny tiny tiny micro-cli to add page numbers to pdf document.

Just puts page number in bright red font on the lower left of every page.  That's it. Does nothing else.

If I get really bored one day, I'll add the capacity to put a "page x of y" or a date or a custom message (exhibit number) or change color or placement or something.  But it's not terribly likely: I just wrote this to learn how to make Gradle actually bundle a dependency and such in the course of learning java (plus because I wanted to number some things).

Usage: 

1.  Have java installed on your system.

2.  Download from [releases](https://github.com/paultopia/batesstamp/releases).

4.  `java -jar batestamp.jar infile outfile` where infile is the original file (e.g. myfile.pdf) and outfile is the name for the page-numbered file (myfile-with-pages.pdf, say).

That's it.

(This is barely even any of my own code; the jar is mostly PDFBox code, and it's actually based on a PDFBox example.  So all that stuff is under the Apache license that Apache put it under; the small rudiments of my own in here code are hereby committed to the public domain.)
