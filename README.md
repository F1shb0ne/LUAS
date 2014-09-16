LUAS
====

Linux User Account System

This package is a library to work with the key basic user account files on the system:

/etc/passwd
/etc/group
/etc/shadow
/etc/gshadow

Planned features are:
  - Check for anomalies; users / groups that may share a common user / group id
  - Comparison of two files of the same type:
    - Check for users / groups existing in one file but not the other
    - Copy non-extant entries from one to another
  - More to come...
