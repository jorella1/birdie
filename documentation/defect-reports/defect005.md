## Defect Report

### ID

    005

### Release
### Date found

    7/4/22

### Date closed


### Summary

    Post constructor not initializing likes

### Description

    Post constructors have like param but never added to the object

### Priority

    very low, functionality still fine. Posts should always start at 0 likes. Possible problem in future if more features are implemented. 

### Severity

    very low

### Steps to Replicate

    Initialize a new post object with likes param as anything but 0. Call getLikes and it will be 0.

### Actual Result

    0 likes

### Expected Result

    15 likes

### Status

    open
    
### Notes

