package campaign

type Service struct {
	Repository Repository
}

func (s *Service) Create(dto NewCampaignDto) (string, error) {
	c, err := NewCampaign(dto.Name, dto.Content, dto.Emails)

	if err != nil {
		return "", err
	}

	return c.ID.String(), s.Repository.Save(c)
}
