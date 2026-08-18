package campaign

import (
	"testing"

	"github.com/stretchr/testify/assert"
	"github.com/stretchr/testify/mock"
)

type RepositoryMock struct {
	mock.Mock
}

func (r *RepositoryMock) Save(c *Campaign) error {
	args := r.Called(c)
	return args.Error(0)
}

func Test_Create_Campaign(t *testing.T) {
	assert := assert.New(t)

	repoMock := new(RepositoryMock)
	repoMock.On("Save", mock.Anything).Return(nil)

	dto := NewCampaignDto{
		Name:    "Test",
		Content: "Content",
		Emails:  []string{"teste@mail.com"},
	}

	service := Service{
		Repository: repoMock,
	}

	_, error := service.Create(dto)

	assert.Nil(error)

	repoMock.AssertExpectations(t)

}
