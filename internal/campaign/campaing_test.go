package campaign

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

var (
	name    = "Holly days"
	content = "Body content"
	emails  = []string{"1@email.com", "2@email.com"}
)

func TestNewCampaign(t *testing.T) {
	assert := assert.New(t)

	c, _ := NewCampaign(name, content, emails)

	assert.NotNil(c.ID)
	assert.NotNil(c.CreatedAt)
	assert.Equal(c.Name, name)
	assert.Equal(c.Content, content)
	assert.Equal(len(c.Contacts), len(emails))
}

func TestNewCampaign_NameAsEmptyString(t *testing.T) {
	assert := assert.New(t)

	_, error := NewCampaign("", content, emails)

	assert.EqualError(error, "name is required")

}

func TestNewCampaign_ContentAsEmptyString(t *testing.T) {
	assert := assert.New(t)

	_, error := NewCampaign(name, "", emails)

	assert.EqualError(error, "content is required")

}
