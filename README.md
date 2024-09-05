# jobapp

# JOB

### FIELDS
* Id
* Job title
* Description
* Minimum salary
* Maximum salary
* Location

### END POINTS
* GET /job
* GET /job/{id}
* POST /job
* PUT /job/{id}
* DELETE /job/{id}


# COMPANIES
### FIELDS
* Id
* Company name
* Industry
* Description
* Address
* Website
* Email
* Phone number

### END POINTS
* GET /companies
* GET /companies/{id}
* POST /companies
* PUT /companies/{id}
* DELETE /companies/{id}

# REVIEWS

### FIELDS
* Id
* Company id
* Rating
* Comment
* Reviewer name
* Review date

### END POINTS
* GET /companies/{companyId}/reviews
* GET /companies/{companyId}/reviews/{reviewsId}
* POST /companies/{companyId}/reviews
* PUT /companies/{companyId}/reviews/{reviewsId}
* DELETE /companies/{companyId}/reviews/{reviewsId}