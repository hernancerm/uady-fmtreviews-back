# API Specification

<!-- TOC -->

- [Endpoints](#endpoints)
  - [GET /api/professors](#get-apiprofessors)
    - [Response](#response)
  - [GET /api/professors/{id}](#get-apiprofessorsid)
    - [Request parameters](#request-parameters)
    - [Response](#response-1)
  - [GET /api/professors/{id}/profile-image](#get-apiprofessorsidprofile-image)
    - [Request parameters](#request-parameters-1)
    - [Response](#response-2)
  - [GET /api/professors/{id}/reviews](#get-apiprofessorsidreviews)
    - [Request parameters](#request-parameters-2)
    - [Response](#response-3)
  - [POST /api/professors/{id}/reviews](#post-apiprofessorsidreviews)
    - [Request parameters](#request-parameters-3)
    - [Request body](#request-body)
    - [Response](#response-4)
  - [GET /api/professors/characteristics](#get-apiprofessorscharacteristics)
    - [Response](#response-5)
- [Entities](#entities)
  - [ProfessorDto](#professordto)
  - [ProfessorSummaryDto](#professorsummarydto)
  - [ProfessorReviewDto](#professorreviewdto)
  - [ProfessorCharacteristicDto](#professorcharacteristicdto)
- [Endpoints per increment](#endpoints-per-increment)
  - [Increment #1](#increment-1)
  - [Increment #2](#increment-2)

<!-- /TOC -->

## Endpoints

### GET /api/professors

Get list of all the professors, non-paginated.

#### Response

200 OK

```text
[ProfessorSummaryDto]
```

### GET /api/professors/{id}

Get complete information for a professor.

#### Request parameters

|Name|Description|Type|Data type|
|---|---|---|---|
|`id`|Id of the professor|path|number|

#### Response

200 OK

```text
ProfessorDto
```

### GET /api/professors/{id}/profile-image

Get the profile image of a professor.

#### Request parameters

|Name|Description|Type|Data type|
|---|---|---|---|
|`id`|Id of the professor|path|number|

#### Response

200 OK

```text
(binary data: an image file)
```

### GET /api/professors/{id}/reviews

Get the reviews associated to a professor, non-paginated.

#### Request parameters

|Name|Description|Type|Data type|
|---|---|---|---|
|`id`|Id of the professor|path|number|

#### Response

```text
[ProfessorReviewDto]
```

### POST /api/professors/{id}/reviews

Create a review for a professor.

#### Request parameters

|Name|Description|Type|Data type|
|---|---|---|---|
|`id`|Id of the professor|path|number|

#### Request body

```text
{
  "body": string,
  "studentSatisfaction": number,
  "sspExpertise": number,
  "sspExplanationQuality": number,
  "sspWillingnessToHelp": number,
  "professorCharacteristics": [ProfessorCharacteristicDto]
}
```

#### Response

201 Created

```text
ProfessorReviewDto
```

### GET /api/professors/characteristics

Get the characteristics of a professor, non-paginated. These are used when posting a review to a professor, since they are associated to a review.

#### Response

200 OK

```text
[ProfessorCharacteristicDto]
```

## Entities

### ProfessorDto

Structure:

```text
{
  "id": number,
  "firstNames": string,
  "lastNames": string,
  "profileImage": string,
  "studentSatisfactionMean": number,
  "sspExpertiseMean": number,
  "sspExplanationQualityMean": number,
  "sspWillingnessToHelpMean": number,
}
```

Example:

```text
{
  "id": 23,
  "firstNames": "Juan",
  "lastNames": "García Saavedra",
  "profileImage": "localhost:8080/api/professors/23/profile-image",
  "studentSatisfactionMean": 4.3,
  "sspExpertiseMean": 4.0,
  "sspExplanationQualityMean": 4.2,
  "sspWillingnessToHelpMean": 3.4,
}
```

### ProfessorSummaryDto

Structure:

```text
{
  "id": number,
  "firstNames": string,
  "lastNames": string
}
```

Example:

```text
{
  "id": 23,
  "firstNames": "Juan",
  "lastNames": "García Saavedra"
}
```

### ProfessorReviewDto

Structure:

```text
{
  "id": number,
  "body": string,
  "studentSatisfaction": number,
  "sspExpertise": number,
  "sspExplanationQuality": number,
  "sspWillingnessToHelp": number,
  "professorCharacteristics": [ProfessorCharacteristicDto]
}
```

Example:

```text
{
  "id": 23,
  "body": "Excelente profesor...",
  "studentSatisfaction": 4.3,
  "sspExpertise": 3.0,
  "sspExplanationQuality": 4.8,
  "sspWillingnessToHelp": 4.2,
  "professorCharacteristics": [ProfessorCharacteristicDto]
}
```

### ProfessorCharacteristicDto

Structure:

```text
{
  "id": number,
  "description": string
}
```

Example:

```text
{
  "id": 3,
  "description": "Muestra interés por la materia"
}
```

## Endpoints per increment

### Increment #1

- `GET /api/professors`
- `GET /api/professors/{id}`
- `GET /api/professors/{id}/profile-image`
- `GET /api/professors/{id}/reviews`
- `POST /api/professors/{id}/reviews`
- `GET /api/professors/characteristics`

### Increment #2

- `GET /api/courses`
- `GET /api/courses/recommended-resource-types`
- `GET /api/courses/{courseId}/recommended-resources`
- `POST /api/courses/{courseId}/recommended-resources`
